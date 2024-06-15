package com.upn.garage.domain.dto

data class UpdateGaragePositionRequest (
    val username: String,
    val state: String,
    val position : Int
)