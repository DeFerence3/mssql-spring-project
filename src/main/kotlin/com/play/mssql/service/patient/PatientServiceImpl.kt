package com.play.mssql.service.patient

import com.play.mssql.dao.patient.PatientDAOImpl
import com.play.mssql.entity.Patient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import jakarta.transaction.Transactional

@Transactional
@Service
class PatientServiceImpl@Autowired constructor(
    private val patientDAOImpl: PatientDAOImpl
): PatientService {
    override fun saveAlist(entity: List<Patient>) {
        return patientDAOImpl.saveAlist(entity)
    }

    override fun getAll(): List<Patient> {
        return patientDAOImpl.all()
    }

    override fun getOne(id: Int): Patient? {
        return patientDAOImpl.findByIdNull(id)
    }

    override fun save(entity: Patient) {
        return patientDAOImpl.save(entity)
    }

    override fun delete(id: Int) {
        return patientDAOImpl.delete(id)
    }
}