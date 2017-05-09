const PROTO_PATH = __dirname + '/../hospital.proto';
const grpc = require('grpc');

/** Creating a stub dynamically **/
const hospitalexaminations = grpc.load(PROTO_PATH);
const doctorStub = new hospitalexaminations.DoctorExaminationsHandling('localhost:51051', grpc.credentials.createInsecure());

/**  all of these methods are asynchronous: they use either events or callbacks to retrieve results */
function runGetExaminationForDoctor(patient, callback) {
    patient.sex === 'male' ? patient.sex = 0 : patient.sex = 1;
    doctorStub.getExaminationForDoctor(patient, (err, examination) => {
        if (err) {
            console.log(err);
        } else {
            callback(examination);
            console.log(examination);
        }
    });
}

/* Stream */
function runGetExaminationsByParameter(parameterName, callback) {
    const parameter = {
        name : parameterName
    };

    let results = [];

    let call = doctorStub.getExaminationsByParameter(parameter);
    call.on('data', (examination) => {
        results.push(examination);
        console.log(`Found examination ${examination}`);
    });
    call.on('end', function() {
        callback(results);
    });
    call.on('status', function(status) {
        console.log(status);
    });
}

/* Stream */
function runGetExaminationsByLastname(lastname, callback) {
    const patient = {
        last_name : lastname
    };

    let results = [];

    let call = doctorStub.getExaminationsByLastname(patient);
    call.on('data', (examination) => {
        results.push(examination);
        console.log(`Found examination ${examination}`);
    });
    call.on('end', function() {
        callback(results);
    });
    call.on('status', function(status) {
        console.log(status);
    });
}

exports.runGetExaminationForDoctor = runGetExaminationForDoctor;
exports.runGetExaminationsByParameter = runGetExaminationsByParameter;
exports.runGetExaminationsByLastname = runGetExaminationsByLastname;