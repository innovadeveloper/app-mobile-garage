package com.upn.garage.domain.dto

data class SessionEntity (
    val id: Int? = null,
    val username: String,
    val password: String,
    val createdAt: String,
    val state: String
)