package com.play.mssql.service.appointments

import com.play.mssql.entity.Appointments

interface AppointmentsService {
    fun getAll(): List<Appointments>
    fun getOne(id: Int): Appointments
    fun save(appointments: List<Appointments>)
    fun delete(id: Int)
    fun getByDay(dayId: Int): List<Appointments>
}