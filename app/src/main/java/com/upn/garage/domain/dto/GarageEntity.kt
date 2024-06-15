package com.upn.garage.domain.dto

data class GarageEntity(
    val id: Int? = null,
    val username: String,
    val position: String,
    val state: String)