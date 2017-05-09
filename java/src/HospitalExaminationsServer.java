import gen.grpc.hospital.examinations.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

public class HospitalExaminationsServer {
    private static final Logger logger = Logger.getLogger(HospitalExaminationsServer.class.getName());

    private final int port;
    private final Server server;

    /** Services implementations **/
    private static class DoctorExaminationsHandlingService extends DoctorExaminationsHandlingGrpc.DoctorExaminationsHandlingImplBase {
        private Collection<Patient> patients;
        private Collection<Examination> examinations;

        DoctorExaminationsHandlingService(Collection<Patient> patients, Collection<Examination> examinations){
            this.patients = patients;
            this.examinations = examinations;
        }

        @Override
        public void getExaminationForDoctor(Patient request, StreamObserver<Examination> responseObserver){
            responseObserver.onNext(checkExamination(request));
            responseObserver.onCompleted();
        }

        private Examination checkExamination(Patient patient) {
            System.out.println("EXAMINATION SUCCESSFULLY GET FROM DATABASE!");
            System.out.println(patient);
            for(Examination examination : examinations){
                if(examination.getPatientId().equals(patient.getId())){
                    return examination;
                }
            }

            // No examination was found, return an unnamed examination.
            return Examination.newBuilder().build();
        }

        @Override
        public void getExaminationsByParameter(Parameter request, StreamObserver<Examination> responseObserver){
            for(Examination examination : examinations){
                for(Parameter parameter : examination.getParameterList()){
                    if(parameter.getName().equalsIgnoreCase(request.getName())){
                        responseObserver.onNext(examination);
                        System.out.println("EXAMINATION SUCCESSFULLY GET FROM DATABASE!");
                        System.out.println(examination);
                        break;
                    }
                }
            }

            responseObserver.onCompleted();
        }

        @Override
        public void getExaminationsByLastname(Patient request, StreamObserver<Examination> responseObserver){
            ArrayList<Patient> patientsWithSameLastname = new ArrayList<>();

            for(Patient patient : patients){
                if(patient.getLastName().equalsIgnoreCase(request.getLastName())){
                    patientsWithSameLastname.add(patient);
                }
            }

            for(Examination examination : examinations){
                for(Patient patientWithSameLastname : patientsWithSameLastname) {
                    if (examination.getPatientId().equals(patientWithSameLastname.getId())) {
                        responseObserver.onNext(examination);
                        System.out.println("EXAMINATION SUCCESSFULLY GET FROM DATABASE!");
                        System.out.println(examination);
                        break;
                    }
                }
            }
            responseObserver.onCompleted();
        }
    }

    private static class LabWorkerExaminationsHandlingService extends LabWorkerExaminationsHandlingGrpc.LabWorkerExaminationsHandlingImplBase {
        private Collection<Examination> examinations;

        LabWorkerExaminationsHandlingService(Collection<Examination> examinations){
            this.examinations = examinations;
        }

        @Override
        public void putExamination(Examination request, StreamObserver<Status> responseObserver){
            DateTime dateTime = DateTime.newBuilder()
                    .setYear(request.getDateTime().getYear())
                    .setMonth(request.getDateTime().getMonth())
                    .setDay(request.getDateTime().getDay())
                    .setHours(request.getDateTime().getHours())
                    .setMinutes(request.getDateTime().getMinutes())
                    .build();

            Examination.Builder examinationBuilder = Examination.newBuilder()
                    .setId(request.getId())
                    .setPatientId(request.getPatientId())
                    .setDateTime(dateTime)
                    .setDoctorId(request.getDoctorId())
                    .addAllParameter(request.getParameterList());

            examinations.add(examinationBuilder.build());
            System.out.println("EXAMINATION SUCCESSFULLY PUT INTO DATABASE!");
            System.out.println(examinations);    // TODO PRINTING
        }
    }

    private static class PatientExaminationsHandlingService extends PatientExaminationsHandlingGrpc.PatientExaminationsHandlingImplBase {
        private Collection<Examination> examinations;

        PatientExaminationsHandlingService(Collection<Examination> examinations){
            this.examinations = examinations;
        }

        @Override
        public void getExaminationForPatient(Patient request, StreamObserver<Examination> responseObserver){
            responseObserver.onNext(checkExamination(request));
            responseObserver.onCompleted();
        }

        private Examination checkExamination(Patient patient) {
            for(Examination examination : examinations){
                if(examination.getPatientId().equals(patient.getId())){
                    System.out.println("EXAMINATION SUCCESSFULLY GET FROM DATABASE!");
                    System.out.println(examination.toString());    // TODO PRINTING
                    return examination;
                }
            }

            // No examination was found, return an unnamed examination.
            return Examination.newBuilder().build();
        }
    }

    private HospitalExaminationsServer(int port, String patientsFile, String examinationsFile) throws IOException, ParseException {
        this(ServerBuilder.forPort(port), port, Parser.parsePatients(patientsFile), Parser.parseExaminations(examinationsFile));
    }

    private HospitalExaminationsServer(ServerBuilder<?> serverBuilder, int port, Collection<Patient> patients, Collection<Examination> examinations){
        this.port = port;
        this.server = serverBuilder
                .addService(new DoctorExaminationsHandlingService(patients, examinations))
                .addService(new LabWorkerExaminationsHandlingService(examinations))
                .addService(new PatientExaminationsHandlingService(examinations))
                .build();

    }

    private void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            HospitalExaminationsServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        final String patients_db = new File("data/patients.json").getAbsolutePath();
        final String examinations_db = new File("data/examinations.json").getAbsolutePath();
        final HospitalExaminationsServer server = new HospitalExaminationsServer(51051, patients_db, examinations_db);

        server.start();
        server.blockUntilShutdown();
    }
}