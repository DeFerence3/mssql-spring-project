package com.play.mssql.controller

import com.play.mssql.entity.ApplicationBusiness
import com.play.mssql.service.applicationbuissness.ApplicationBusinessServiceImpl
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/app-business")
@Transactional
class ApplicationBusinessController @Autowired constructor(
    private val applicationBusinessServiceImpl: ApplicationBusinessServiceImpl
) {
    @PostMapping("/save")
    fun save(@RequestBody applicationBusiness: ApplicationBusiness) {
        applicationBusinessServiceImpl.save(applicationBusiness)
    }

    @GetMapping("/all")
    fun getAll(): List<ApplicationBusiness> {
        return applicationBusinessServiceImpl.getAll()
    }
}