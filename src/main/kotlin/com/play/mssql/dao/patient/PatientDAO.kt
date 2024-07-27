package com.play.mssql.dao.patient

import com.play.mssql.dao.GenericDAO
import com.play.mssql.entity.Patient

interface PatientDAO: GenericDAO<Patient,Int> {
    fun saveAlist(entity: List<Patient>)
    fun findByIdNull(id: Int): Patient?
}