package com.play.mssql.entity

import jakarta.persistence.*

@Entity
@Table(name = "Leads")
data class Leads(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Int = 0,

    @Column(name = "serverLeadId", nullable = false)
    val serverLeadId: Int = 0,

    @Column(name = "name", nullable = false)
    val name: String = "",

    @Column(name = "phone", nullable = false)
    val phone: String = "",

    @Column(name = "address", nullable = false)
    val address: String = "",

    @Column(name = "details", nullable = false)
    val details: String = "",

    @Column(name = "info", nullable = false)
    val info: String = "",

    @Column(name = "date", nullable = false)
    val date: String = "",

    @Column(name = "email", nullable = false)
    val email: String = "",

    @Column(name = "contact_person", nullable = false)
    val contact_person: String = "",

    @Column(name = "pin_number", nullable = false)
    val pin_number: String = "",

    @Column(name = "place", nullable = false)
    val place: String = "",

    @Column(name = "state", nullable = false)
    val state: String = "",

    @Column(name = "district", nullable = false)
    val district: String = "",

    @Column(name = "customer_type", nullable = false)
    val customer_type: String = "",

    @Column(name = "gst_number", nullable = false)
    val gst_number: String = "",
)
