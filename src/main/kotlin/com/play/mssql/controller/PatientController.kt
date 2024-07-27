package com.play.mssql.controller

import com.play.mssql.core.Responser
import com.play.mssql.entity.Patient
import com.play.mssql.model.Usercreds
import com.play.mssql.service.patient.PatientServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/patient")
@Transactional
class PatientController@Autowired constructor(
    private val patientServiceImpl: PatientServiceImpl
) {
    @PostMapping("/save")
    fun save(@RequestBody patient: List<Patient>) {
        patientServiceImpl.saveAlist(patient)
    }

    @GetMapping("/all")
    fun getAll(): List<Patient> {
        return patientServiceImpl.getAll()
    }

    @GetMapping("/getOne")
    fun getOne(@RequestParam patientId: Int): ResponseEntity<Responser> {
        val patient = patientServiceImpl.getOne(patientId)
        val response: ResponseEntity<Responser>

        if (patient != null) {
            val patientResponse = Responser("Success", "200", patient)
            response = ResponseEntity.ok(patientResponse)
        } else {
            val patientResponse = Responser("Patient not found", "404", null)
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(patientResponse)
        }
        return response
    }
}