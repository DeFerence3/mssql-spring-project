package com.play.mssql.entity

import jakarta.persistence.*

@Entity
@Table(name = "UserRoles")
data class UserRoles(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserRoleId", nullable = false)
    val userRoleId: Long = 0,

    /*@Column(name = "ApplicationBusinessId")
    val applicationBusinessId: Long,*/

    @ManyToMany
    @JoinTable(
        name = "UserRoleApplicationBusiness",
        joinColumns = [JoinColumn(name = "UserRoleId")],
        inverseJoinColumns = [JoinColumn(name = "ApplicationBusinessId")]
    )
    val applicationBusinesses: Set<ApplicationBusiness>? = null
)
