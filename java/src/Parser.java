import gen.grpc.hospital.examinations.*;

import java.io.*;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private static JSONParser parser = new JSONParser();

    public static List<Patient> parsePatients(String patientsFile) throws IOException, ParseException {
        ArrayList<Patient> patientsList = new ArrayList<>();

        Object obj = parser.parse(new FileReader(patientsFile));
        JSONArray jsonarray = (JSONArray) obj;

        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject jsonobject = (JSONObject) jsonarray.get(i);
            String id = (String) jsonobject.get("id");
            String firstName = (String) jsonobject.get("first_name");
            String lastName = (String) jsonobject.get("last_name");
            String sexString = (String) jsonobject.get("sex");

            Patient.Sex sex;
            if(sexString.equals("male")){
                sex = Patient.Sex.MALE;
            }
            else{
                sex = Patient.Sex.FEMALE;
            }

            patientsList.add(Patient.newBuilder()
                    .setId(id)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setSex(sex)
                    .build());
        }

        return patientsList;
    }


    public static List<Examination> parseExaminations(String examinationsFile) throws IOException, ParseException {
        ArrayList<Examination> examinationsList = new ArrayList<>();
        ArrayList<Parameter> parameterList = new ArrayList<>();

        Object obj = parser.parse(new FileReader(examinationsFile));
        JSONArray jsonarray = (JSONArray) obj;
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject jsonobject = (JSONObject) jsonarray.get(i);
            Long id = (Long) jsonobject.get("id");
            String patientId = (String) jsonobject.get("patient_id");

            JSONArray dataTime = new JSONArray();
            dataTime.add(jsonobject.get("date_time"));

            JSONObject jsonobject1 = (JSONObject) dataTime.get(0);
            Long year = (Long) jsonobject1.get("year");
            Long month = (Long) jsonobject1.get("month");
            Long day = (Long) jsonobject1.get("day");
            Long hours = (Long) jsonobject1.get("hours");
            Long minutes = (Long) jsonobject1.get("minutes");

            DateTime dateTime = DateTime.newBuilder()
                    .setYear(year.intValue())
                    .setMonth(month.intValue())
                    .setDay(day.intValue())
                    .setHours(hours.intValue())
                    .setMinutes(minutes.intValue())
                    .build();

            JSONArray parameters = (JSONArray) jsonobject.get("parameter");
            for(int j = 0; j < parameters.size(); j++){
                JSONObject jsonobject2 = (JSONObject) parameters.get(j);
                String name = (String) jsonobject2.get("name");
                Object value = jsonobject2.get("value");
                String unit = (String) jsonobject2.get("unit");
                Parameter parameter = Parameter.newBuilder()
                        .setName(name)
                        .setValue(Double.valueOf(value.toString()))
                        .setUnit(unit)
                        .build();
                parameterList.add(parameter);
            }

            Long doctorId = (Long) jsonobject.get("doctor_id");

            examinationsList.add(Examination.newBuilder()
                    .setId(id.intValue())
                    .setPatientId(patientId)
                    .setDateTime(dateTime)
                    .setDoctorId(doctorId.intValue())
                    .addAllParameter(parameterList)
                    .build());

            parameterList.clear();
        }

        return examinationsList;
    }

    public static List<Doctor> parseDoctors(String doctorsFile) throws IOException, ParseException {
        ArrayList<Doctor> doctorList = new ArrayList<>();

        Object obj = parser.parse(new FileReader(doctorsFile));
        JSONArray jsonarray = (JSONArray) obj;



        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject jsonobject = (JSONObject) jsonarray.get(i);
            Long id = (Long) jsonobject.get("id");
            String firstName = (String) jsonobject.get("first_name");
            String lastName = (String) jsonobject.get("last_name");

            doctorList.add(Doctor.newBuilder()
                    .setId(id.intValue())
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .build());
        }

        return doctorList;
    }
}
