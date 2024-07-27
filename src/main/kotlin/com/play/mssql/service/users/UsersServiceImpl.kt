package com.play.mssql.service.users

import com.play.mssql.dao.users.UsersDAOImpl
import com.play.mssql.entity.Users
import com.play.mssql.model.Usercreds
import org.apache.commons.text.RandomStringGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsersServiceImpl @Autowired constructor(
    private val usersDAOImpl: UsersDAOImpl
): UsersService {
    override fun authenticate(usercreds: Usercreds): String? {
        var key: String? = null
        if (!usersDAOImpl.checkUser(usercreds.username))
        key = if (!usersDAOImpl.checkPassword(usercreds.password))
            null
        else {
            val generator = RandomStringGenerator.Builder()
                .withinRange('a'.code, 'z'.code)
                .build()
            generator.generate(13)
        }

        return key
    }

    override fun getAll(): List<Users> {
        return usersDAOImpl.all()
    }

    override fun getOne(id: Long): Users {
        return usersDAOImpl.findById(id)
    }

    override fun save(entity: Users) {
        usersDAOImpl.save(entity)
    }

    override fun delete(id: Long) {
        usersDAOImpl.delete(id)
    }



}