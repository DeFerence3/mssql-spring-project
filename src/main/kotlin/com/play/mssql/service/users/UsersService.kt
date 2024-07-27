package com.play.mssql.service.users

import com.play.mssql.entity.Users
import com.play.mssql.model.Usercreds
import com.play.mssql.service.GenericService


interface UsersService: GenericService<Users,Long> {
    fun authenticate(usercreds: Usercreds): String?
}