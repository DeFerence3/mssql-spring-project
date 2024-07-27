package com.play.mssql.service.leads

import com.play.mssql.dao.leadsdao.LeadsDAOImpl
import com.play.mssql.entity.Leads
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeadsServiceImpl @Autowired constructor(
    private val leadsDAOImpl: LeadsDAOImpl
) : LeadsService {
    override fun getAll(): List<Leads> {
        return leadsDAOImpl.all()
    }

    override fun getOne(id: Int): Leads? {
        return leadsDAOImpl.findById(id)
    }

    override fun save(entity: Leads) {
        println("Saved")
        leadsDAOImpl.save(entity)
    }

    override fun delete(id: Int) {
        leadsDAOImpl.delete(id)
    }

}