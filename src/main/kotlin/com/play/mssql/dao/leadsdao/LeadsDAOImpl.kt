package com.play.mssql.dao.leadsdao

import com.play.mssql.entity.Leads
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class LeadsDAOImpl@Autowired constructor(
    private val entityManager: EntityManager
): LeadsDAO  {

    override fun save(entity: Leads) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.merge(entity)
    }

    override fun findById(id: Int): Leads {
        val currentSession = entityManager.unwrap(Session::class.java)
        println("Id---> $id")
        return currentSession[Leads::class.java,id]
    }

    override fun all(): List<Leads> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<Leads> = currentSession.createQuery("from Leads", Leads::class.java)
        return query.resultList.also { currentSession.close() }
    }

    override fun delete(id: Int) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val patient: Leads = currentSession[Leads::class.java, id]
        currentSession.remove(patient)
    }
}