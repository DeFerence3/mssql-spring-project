package com.play.mssql.dao

interface GenericDAO<T: Any,ID: Any> {
    fun save(entity: T)
    fun findById(id: ID):T
    fun all(): List<T>
    fun delete(id: ID)
}