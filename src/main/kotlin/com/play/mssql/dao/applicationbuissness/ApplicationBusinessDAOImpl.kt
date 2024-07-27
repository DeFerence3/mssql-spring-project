package com.play.mssql.dao.applicationbuissness

import com.play.mssql.entity.ApplicationBusiness
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ApplicationBusinessDAOImpl @Autowired constructor(
    private val entityManager: EntityManager
): ApplicationBusinessDAO {

    override fun save(entity: ApplicationBusiness) {
        val currentSession = entityManager.unwrap(Session::class.java)
        println(entity)
        currentSession.merge(entity)
        currentSession.close()
    }

    override fun findById(id: Long): ApplicationBusiness {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession[ApplicationBusiness::class.java,id].also { currentSession.close() }
    }

    override fun all(): List<ApplicationBusiness> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<ApplicationBusiness> = currentSession.createQuery("from ApplicationBusiness", ApplicationBusiness::class.java)
        return query.resultList.also { currentSession.close() }
    }

    override fun delete(id: Long) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val applicationBusiness: ApplicationBusiness = currentSession[ApplicationBusiness::class.java, id]
        currentSession.remove(applicationBusiness)
    }
}