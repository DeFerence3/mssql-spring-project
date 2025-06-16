package com.play.mssql.model.apierror

import org.springframework.http.HttpStatus

class ApiError(private val status: HttpStatus, private val message: String, private val errors: List<String>)
