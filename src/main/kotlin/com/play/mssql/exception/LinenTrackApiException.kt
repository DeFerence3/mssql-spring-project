package com.play.mssql.exception

import org.springframework.http.HttpStatus

class LinenTrackApiException : RuntimeException {
    private val status: HttpStatus
    override val message: String

    constructor(status: HttpStatus, message: String) {
        this.status = status
        this.message = message
    }

    constructor(message: String?, status: HttpStatus, message1: String) : super(message) {
        this.status = status
        this.message = message1
    }
}
