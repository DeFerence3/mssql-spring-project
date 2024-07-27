package com.play.mssql.service.applicationbuissness

import com.play.mssql.dao.applicationbuissness.ApplicationBusinessDAOImpl
import com.play.mssql.entity.ApplicationBusiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicationBusinessServiceImpl @Autowired constructor(
    private val applicationBusinessDAOImpl: ApplicationBusinessDAOImpl
) : ApplicationBusinessService {

    override fun getAll(): List<ApplicationBusiness> {
        return applicationBusinessDAOImpl.all()
    }

    override fun getOne(id: Long): ApplicationBusiness {
        return applicationBusinessDAOImpl.findById(id)
    }

    override fun save(applicationBusiness: ApplicationBusiness) {
        applicationBusinessDAOImpl.save(applicationBusiness)
    }

    override fun delete(id: Long) {
        applicationBusinessDAOImpl.delete(id)
    }

}