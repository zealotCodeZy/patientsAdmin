package com.example.patientsAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping
    public List<PatientRecord> getAllRecords() {
        return patientRecordRepository.findAll();
    }

    @GetMapping(value = "{patientId}")
    public PatientRecord getPatientById(@PathVariable(value="patientId") Long patientId) {
        return patientRecordRepository.findById(patientId).get();
    }
    @PostMapping
    public PatientRecord createRecord(@RequestBody PatientRecord patientRecord) {
        return patientRecordRepository.save(patientRecord);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    class InvalidRequestException extends RuntimeException {
        public InvalidRequestException(String s) {
            super(s);
        }
    }
}
