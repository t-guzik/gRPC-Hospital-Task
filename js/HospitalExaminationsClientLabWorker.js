const PROTO_PATH = __dirname + '/../hospital.proto';
const grpc = require('grpc');

/** Creating a stub dynamically **/
const hospitalexaminations = grpc.load(PROTO_PATH);
const labWorkerStub = new hospitalexaminations.LabWorkerExaminationsHandling('localhost:51051', grpc.credentials.createInsecure());

function runPutExamination(id, patient_id, doctor_id, parameters) {
    const date = new Date();

    const examination = {
        id : id,
        patient_id : patient_id,
        date_time : {
            year : date.getFullYear(),
            month : date.getMonth(),
            day : date.getDate(),
            hours : date.getHours(),
            minutes : date.getMinutes()
        },
        doctor_id : doctor_id,
        parameter : parameters
    };

    labWorkerStub.putExamination(examination, (err, status) => {
        if (err) {
            console.log(err);
        } else {
            console.log(`Data put into database: ${status}`);
        }
    });
}

exports.runPutExamination = runPutExamination;
