package com.play.mssql.entity

import jakarta.persistence.*

@Entity
@Table(name = "ApplicationBusiness")
data class ApplicationBusiness(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ApplicationBusinessID")
    val applicationBusinessId: Long = 0,

    @Column(name = "MenuLabel", length = 100, nullable = false)
    val menuLabel: String = "",

    @Column(name = "MenuId", nullable = false)
    val menuId: Int = 0
)
