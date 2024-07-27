package com.play.mssql.service.applicationbuissness

import com.play.mssql.entity.ApplicationBusiness

interface ApplicationBusinessService {
    fun getAll(): List<ApplicationBusiness>
    fun getOne(id: Long): ApplicationBusiness
    fun save(applicationBusiness: ApplicationBusiness)
    fun delete(id: Long)
}