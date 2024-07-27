package com.play.mssql.dao.userroles

import com.play.mssql.entity.UserRoles
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRolesDAOImpl @Autowired constructor(
    private val entityManager: EntityManager
): UserRolesDAO {
    override fun save(entity: UserRoles) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.merge(entity)
    }

    override fun findById(id: Long): UserRoles {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession[UserRoles::class.java,id]
    }

    override fun all(): List<UserRoles> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<UserRoles> = currentSession.createQuery("from UserRoles", UserRoles::class.java)
        return query.resultList.also { currentSession.close() }
    }

    override fun delete(id: Long) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val userRoles: UserRoles = currentSession[UserRoles::class.java, id]
        currentSession.remove(userRoles)
    }
}