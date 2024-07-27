package com.play.mssql.dao.users

import com.play.mssql.dao.GenericDAO
import com.play.mssql.entity.Users

interface UsersDAO: GenericDAO<Users, Long> {
    fun checkUser(username: String): Boolean
    fun checkPassword(password: String): Boolean
}