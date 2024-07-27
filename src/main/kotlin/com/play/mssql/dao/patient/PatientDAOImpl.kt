package com.play.mssql.dao.patient

import com.play.mssql.entity.Patient
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class PatientDAOImpl@Autowired constructor(
    private val entityManager: EntityManager
): PatientDAO  {
    override fun saveAlist(entity: List<Patient>) {
        val currentSession = entityManager.unwrap(Session::class.java)
        entity.forEach {
            currentSession.merge(it)
        }
    }

    override fun findByIdNull(id: Int): Patient? {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession[Patient::class.java,id]
    }

    override fun save(entity: Patient) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.merge(entity)
    }

    override fun findById(id: Int): Patient {
        val currentSession = entityManager.unwrap(Session::class.java)
        println("Id---> $id")
        return currentSession[Patient::class.java,id]
    }

    override fun all(): List<Patient> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<Patient> = currentSession.createQuery("from Patient", Patient::class.java)
        return query.resultList.also { currentSession.close() }
    }

    override fun delete(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val patient: Patient = currentSession[Patient::class.java, id]
        currentSession.remove(patient)
    }
}