package com.play.mssql.service

interface GenericService<T: Any,ID: Any> {
    fun getAll(): List<T>
    fun getOne(id: ID): T?
    fun save(entity: T)
    fun delete(id: ID)
}