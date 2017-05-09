const PROTO_PATH = __dirname + '/../hospital.proto';
const grpc = require('grpc');

/** Creating a stub dynamically **/
const hospitalexaminations = grpc.load(PROTO_PATH);
const patientStub = new hospitalexaminations.PatientExaminationsHandling('localhost:51051', grpc.credentials.createInsecure());

function runGetExaminationForPatient(patient, callback) {
    patient.sex === 'male' ? patient.sex = 0 : patient.sex = 1;
    patientStub.getExaminationForPatient(patient, (err, examination) => {
        if (err) {
            console.log(err);
        } else {
            callback(examination);
            console.log(examination);
        }
    });
}

exports.runGetExaminationForPatient = runGetExaminationForPatient;