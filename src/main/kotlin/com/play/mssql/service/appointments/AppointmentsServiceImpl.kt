package com.play.mssql.service.appointments

import com.play.mssql.dao.appointments.AppointmentsDAOImpl
import com.play.mssql.entity.Appointments
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AppointmentsServiceImpl @Autowired constructor(
    private val appointmentsDAOImpl: AppointmentsDAOImpl
): AppointmentsService {
    override fun getAll(): List<Appointments> {
        return appointmentsDAOImpl.all()
    }

    override fun getOne(id: Int): Appointments {
        return appointmentsDAOImpl.findById(id)
    }

    override fun save(appointments: List<Appointments>) {
        return appointmentsDAOImpl.savelist(appointments)
    }

    override fun delete(id: Int) {
        return appointmentsDAOImpl.delete(id)
    }

    override fun getByDay(dayId: Int): List<Appointments> {
        return appointmentsDAOImpl.getByDay(dayId)
    }
}