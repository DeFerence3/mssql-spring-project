package com.play.mssql.dao

import org.springframework.data.repository.CrudRepository
import java.util.*

open class GenericDAOImpl<T: Any, ID: Any>(
    private val repository: CrudRepository<T, ID>
) : GenericDAO<T, ID> {

    override fun save(entity: T) {
        repository.save(entity)
    }

    override fun findById(id: ID): T {
        val optionalEntity: Optional<T> = repository.findById(id)
        return optionalEntity.orElse(null)
    }

    override fun all(): List<T> {
        return repository.findAll().toList()
    }

    override fun delete(id: ID) {
        repository.deleteById(id)
    }
}
