const labWorkerClient = require('./HospitalExaminationsClientLabWorker');
const patientClient = require('./HospitalExaminationsClientPatient');
const doctorClient = require('./HospitalExaminationsClientDoctor');

let doctorsDB = require('../data/doctors.json');
let patientsDB = require('../data/patients.json');

const express = require('express');
const hbs = require('hbs');
const bodyParser = require('body-parser');
const http = require('http');
const app = express();
const server = http.createServer(app);
const PORT = 3000;

let examination_id = 11;

app.set('views', 'views');
app.set('view engine', 'hbs');
app.use(express.static('static'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.get('/', (req, res) => {
   res.render('welcome', {
       layout: 'main'
   });
});

app.get('/patient', (req, res) => {
    res.render('patient-login', {
        layout: 'main'
    });
});

app.post('/patient', (req, res) => {
    patientsDB.map((patient) =>{
        if(patient.id === req.body.id){
            if(req.body.id === req.body.pwd){
                let examinationReady = (examination) => {
                    let doctorObj = {};

                    doctorsDB.map((doctor) => {if(doctor.id === examination.doctor_id) doctorObj = doctor;});

                    res.render('patient-examination', {
                        layout: 'main',
                        examination: {
                            id: examination.id,
                            patient: patient,
                            date_time: {
                                year: examination.date_time.year,
                                month: examination.date_time.month,
                                day: examination.date_time.day,
                                hours: examination.date_time.hours,
                                minutes: examination.date_time.minutes
                            },
                            doctor: doctorObj,
                            parameters: examination.parameter
                        }
                    });
                };

                patientClient.runGetExaminationForPatient(patient, examinationReady);
            }
        }
    });
});

app.get('/doctor', (req, res) => {
    res.render('doctor-login', {
        layout: 'main'
    });
});

app.post('/doctor', (req, res) => {
    doctorsDB.map((doctor) => {
        if (doctor.id == req.body.id) {
            if (req.body.id === req.body.pwd) {
                res.render('doctor-examinations', {
                    layout: 'main'
                });
            }
        }
    });
});

app.post('/doctorsingle', (req, res) => {
    patientsDB.map((patient) =>{
        if(patient.id === req.body.id){
            let examinationReady = (examination) => {
                let doctorObj = {};

                doctorsDB.map((doctor) => {
                    if (doctor.id === examination.doctor_id) doctorObj = doctor;
                });

                res.render('patient-examination', {
                    layout: 'main',
                    examination: {
                        id: examination.id,
                        patient: patient,
                        date_time: {
                            year: examination.date_time.year,
                            month: examination.date_time.month,
                            day: examination.date_time.day,
                            hours: examination.date_time.hours,
                            minutes: examination.date_time.minutes
                        },
                        doctor: doctorObj,
                        parameters: examination.parameter
                    }
                });
            };

            doctorClient.runGetExaminationForDoctor(patient, examinationReady);
        }
    });
});

app.post('/doctorparameter', (req, res) => {
    let examinationsReady = (examinations) => {
        res.render('doctor-results', {
            layout: 'main',
            examinations: examinations
        });
    };

    doctorClient.runGetExaminationsByParameter(req.body.parameter, examinationsReady);
});

app.post('/doctorlastname', (req, res) => {
    let examinationsReady = (examinations) => {
        res.render('doctor-results', {
            layout: 'main',
            examinations: examinations
        });
    };

    doctorClient.runGetExaminationsByLastname(req.body.lastname, examinationsReady);
});

app.post('/doctordate', (req, res) => {
    let examinationsReady = (examinations) => {
        res.render('doctor-results', {
            layout: 'main',
            examinations: examinations
        });
    };

    doctorClient.runGetExaminationsByParameter(req.body.parameter, examinationsReady);
});

app.get('/labworker', (req, res) => {
    res.render('lab-worker-panel', {
        layout: 'main'
    });
});

app.post('/labworker', (req, res) => {
    res.sendStatus(200);

    let parameters = [];
    for(let param in req.body){
        parameters.push({
            name: param,
            value: Number(req.body[param]),
            unit: param.toLowerCase() === 'iron' ? 'μg/dl' : 'mg/dl'
        });
    }

    labWorkerClient.runPutExamination(examination_id++, req.body.patient_id, Number(req.body.doctor_id), parameters.slice(2));
});

server.listen(PORT, '127.0.0.1');
console.log('Listening on port ' + PORT + '...');
