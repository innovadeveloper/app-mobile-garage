package com.upn.garage.domain.dto

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("message") val message: String,
    @SerializedName("isValid") val isValid: Boolean,
    @SerializedName("id") val id : Int?
)