package com.play.mssql.entity

import jakarta.persistence.*

@Entity
@Table(name = "Users")
data class Users (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    val id: Long = 0,

    @Column(name = "Name", nullable = false)
    val name: String? = null,

    @Column(name = "Username", nullable = false, unique = true)
    val username: String? = null,

    @Column(name = "Password", nullable = false)
    val password: String? = null,
)