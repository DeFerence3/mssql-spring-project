package com.play.mssql.controller

import com.play.mssql.core.Responser
import com.play.mssql.entity.Leads
import com.play.mssql.exception.LinenTrackApiException
import com.play.mssql.service.leads.LeadsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/leads")
@Transactional
class LeadsController @Autowired constructor(
    private val leadsServiceImpl: LeadsServiceImpl
) {
    @PostMapping("/save")
    fun save(@RequestBody leads: Leads) {
        print("Leads: $leads")
        leadsServiceImpl.save(leads)
    }

    @GetMapping("/all")
    fun getAll(): List<Leads> {
        return leadsServiceImpl.getAll()
    }

    @GetMapping("/getOne")
    fun getOne(@RequestParam patientId: Int): ResponseEntity<Responser> {

        println("PatientId:$patientId")
        if (patientId == 0 ) {
            throw LinenTrackApiException(HttpStatus.NOT_FOUND,"Bad req")
        }

        val patient = leadsServiceImpl.getOne(patientId)
        val response: ResponseEntity<Responser>

        if (patient != null) {
            val patientResponse = Responser("Success", "200", patient)
            response = ResponseEntity.ok(patientResponse)
        } else {
            val patientResponse = Responser("Leads not found", "404", null)
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(patientResponse)
        }
        return response
    }
}