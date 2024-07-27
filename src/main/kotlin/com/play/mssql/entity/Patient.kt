package com.play.mssql.entity

import jakarta.persistence.*

@Entity
@Table(name = "Patient")
data class Patient(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientID", nullable = false)
    val patientId: Int = 0,
    
    @Column(name = "admissionDate", nullable = false)
    val admissionDate: String = "",

    @Column(name = "age", nullable = false)
    val age: Int = 0,

    @Column(name = "dob", nullable = false)
    val dob: String = "",

    @Column(name = "doctor", nullable = false)
    val doctor: String = "",

    @Column(name = "gender", nullable = false)
    val gender: String = "",

    @Column(name = "mobileNo", nullable = false)
    val mobileNo: String = "",

    @Column(name = "month", nullable = false)
    val month: Int = 0,

    @Column(name = "patientCode", nullable = false)
    val patientCode: String = "",

    @Column(name = "patientName", nullable = false, unique = true)
    val patientName: String = "",

    @Column(name = "place", nullable = false)
    val place: String = ""
)