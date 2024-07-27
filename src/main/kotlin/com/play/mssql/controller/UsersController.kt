package com.play.mssql.controller

import com.play.mssql.entity.Users
import com.play.mssql.model.Usercreds
import com.play.mssql.service.users.UsersServiceImpl
import jakarta.servlet.annotation.MultipartConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@RestController
@RequestMapping("/users")
@Transactional
class UsersController @Autowired constructor(
    private val usersServiceImpl: UsersServiceImpl
) {

    @PostMapping("/save")
    fun save(@RequestBody users: Users) {
        usersServiceImpl.save(users)
    }

    @GetMapping("/all")
    fun getAll(): List<Users> {
        return usersServiceImpl.getAll()
    }

    @PostMapping("/auth", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun authenticate(@RequestBody usercreds: Usercreds): String? {
        return usersServiceImpl.authenticate(usercreds)
    }
}