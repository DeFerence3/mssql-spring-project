package com.play.mssql.dao.appointments

import com.play.mssql.entity.Appointments
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class AppointmentsDAOImpl @Autowired constructor(
    private val entityManager: EntityManager
): AppointmentsDAO {
    override fun savelist(entity: List<Appointments>) {
        val currentSession = entityManager.unwrap(Session::class.java)
        entity.forEach {
            currentSession.merge(it)
        }
    }

    override fun getByDay(dayId: Int): List<Appointments> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<Appointments> = when(dayId) {
            2 -> {
                currentSession.createQuery("from Appointments where appointmentScheduleDate = '2021-09-01T00:00:00'", Appointments::class.java)
            }
            3 -> {
                currentSession.createQuery("from Appointments where isWalkin = true", Appointments::class.java)
            }

            else -> currentSession.createQuery("from Appointments", Appointments::class.java)
        }
        return query.resultList.also { currentSession.close() }
    }

    override fun save(entity: Appointments) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.merge(entity)
    }

    override fun findById(id: Int): Appointments {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession[Appointments::class.java,id]
    }

    override fun all(): List<Appointments> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<Appointments> = currentSession.createQuery("from Appointments", Appointments::class.java)
        return query.resultList.also { currentSession.close() }
    }

    override fun delete(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val appointments: Appointments = currentSession[Appointments::class.java, id]
        currentSession.remove(appointments)
    }
}