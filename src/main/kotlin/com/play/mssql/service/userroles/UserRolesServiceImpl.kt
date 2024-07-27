package com.play.mssql.service.userroles

import com.play.mssql.dao.userroles.UserRolesDAOImpl
import com.play.mssql.entity.UserRoles
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Transactional
@Service
class UserRolesServiceImpl @Autowired constructor(
    private val userRolesDAOImpl: UserRolesDAOImpl
):UserRoleService {
    override fun getAll(): List<UserRoles> {
        return userRolesDAOImpl.all()
    }

    override fun getOne(id: Long): UserRoles {
        return userRolesDAOImpl.findById(id)
    }

    override fun save(entity: UserRoles) {
        return userRolesDAOImpl.save(entity)
    }

    override fun delete(id: Long) {
        userRolesDAOImpl.delete(id)
    }
}