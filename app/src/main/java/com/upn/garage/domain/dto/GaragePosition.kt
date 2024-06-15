package com.upn.garage.domain.dto

data class GaragePosition (
    val id: Int,
    val username: String? = "",
    val position: Int,
    val state: String
)
