package com.play.mssql.controller

import com.play.mssql.core.Responser
import com.play.mssql.entity.Appointments
import com.play.mssql.service.appointments.AppointmentsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appointments")
@Transactional
class AppointmentsController @Autowired constructor(
    private val appointmentsServiceImpl: AppointmentsServiceImpl
) {
    @GetMapping("/all")
    fun getAll(): ResponseEntity<Responser> {
        val appointments = appointmentsServiceImpl.getAll()
        val response: ResponseEntity<Responser>
        val patientResponse = Responser("Success", "200", appointments)
        response = ResponseEntity.ok(patientResponse)
        return response
    }

    @GetMapping("/getByDay")
    fun getByDay(@RequestParam dayId: Int): ResponseEntity<Responser> {
        val appointments = appointmentsServiceImpl.getByDay(dayId)
        val response: ResponseEntity<Responser>
        val message = if (appointments.isEmpty()) "List Empty" else "Success"
        val patientResponse = Responser(message, "200", appointments)
        response = ResponseEntity.ok(patientResponse)
        return response
    }

    @PostMapping("/save")
    fun save(@RequestBody appointments: List<Appointments>) {
        appointmentsServiceImpl.save(appointments)
    }
}