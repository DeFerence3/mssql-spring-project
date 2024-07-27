package com.play.mssql.service.patient

import com.play.mssql.entity.Patient
import com.play.mssql.service.GenericService

interface PatientService: GenericService<Patient,Int> {
    fun saveAlist(entity: List<Patient>)
}