package com.play.mssql.entity

import jakarta.persistence.*

@Entity
@Table(name = "Appointments")
data class Appointments(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentScheduleItemID", nullable = false)
    val appointmentScheduleItemID: Int = 0,

    @Column(name = "patientID", nullable = false)
    val patientID: Int = 0,

    @Column(name = "code", nullable = false)
    val code: String = "",

    @Column(name = "name", nullable = false)
    val name: String = "",

    @Column(name = "time", nullable = false)
    val time: String = "",

    @Column(name = "tokenNo", nullable = false)
    val tokenNo: Int = 0,

    @Column(name = "appointmentScheduleDate", nullable = false)
    val appointmentScheduleDate: String = "",

    @Column(name = "opid", nullable = false)
    val opid: Int = 0,

    @Column(name = "isCompleted", nullable = false)
    val isCompleted: Boolean = false,

    @Column(name = "isReferedIP", nullable = false)
    val isReferedIP: Boolean = false,

    @Column(name = "isWalkin", nullable = false)
    val isWalkin: Boolean = false,

    @Column(name = "reviewID", nullable = false)
    val reviewID: Int = 0
)
