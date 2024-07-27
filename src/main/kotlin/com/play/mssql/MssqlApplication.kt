package com.play.mssql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MssqlApplication

fun main(args: Array<String>) {
	runApplication<MssqlApplication>(*args)
}