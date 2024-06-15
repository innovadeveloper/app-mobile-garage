package com.upn.garage.domain.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    val message: String,
    val isValid: Boolean,
    val sessionID: Long,
    val user: User
)

data class User (
    val id: String,
    @SerializedName("fullname")
    val fullName: String,
    val username: String,
    val password: String,
    val createdAt: String,
    val state: String,
    val role: String
)
