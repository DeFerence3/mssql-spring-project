package com.play.mssql.dao.users

import com.play.mssql.entity.Users
import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.hibernate.query.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UsersDAOImpl @Autowired constructor(
    private val entityManager: EntityManager
) : UsersDAO {
    override fun checkUser(username: String): Boolean {
        val currentSession: Session = entityManager.unwrap(Session::class.java)
        val query: Query<Users> = currentSession.createQuery("from Users where username = :username", Users::class.java)
        query.setParameter("username",username)
        return query.resultList.isNotEmpty()
    }

    override fun checkPassword(password: String): Boolean {
        val currentSession: Session = entityManager.unwrap(Session::class.java)
        val query: Query<Users> = currentSession.createQuery("from Users where password = :password", Users::class.java)
        query.setParameter("password",password)
        return query.resultList.isNotEmpty()
    }

    override fun save(entity: Users) {
        val currentSession = entityManager.unwrap(Session::class.java)
        currentSession.merge(entity)
    }

    override fun findById(id: Long): Users {
        val currentSession = entityManager.unwrap(Session::class.java)
        return currentSession[Users::class.java, id]
    }

    override fun all(): List<Users> {
        val currentSession = entityManager.unwrap(Session::class.java)
        val query: Query<Users> = currentSession.createQuery("from Users", Users::class.java)
        return query.resultList
    }

    override fun delete(id: Long) {
        val currentSession = entityManager.unwrap(Session::class.java)
        val users: Users = currentSession[Users::class.java, id]
        currentSession.remove(users)
    }
}