package com.play.mssql.dao.appointments

import com.play.mssql.dao.GenericDAO
import com.play.mssql.entity.Appointments

interface AppointmentsDAO: GenericDAO<Appointments,Int> {
    fun savelist(entity: List<Appointments>)
    fun getByDay(dayId: Int): List<Appointments>
}