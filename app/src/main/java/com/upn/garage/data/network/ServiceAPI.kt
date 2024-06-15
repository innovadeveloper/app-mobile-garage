package com.upn.garage.data.network

import com.upn.garage.domain.dto.ApiResponse
import com.upn.garage.domain.dto.LoginRequest
import com.upn.garage.domain.dto.SessionEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    // curl -X POST -H "Content-Type: application/json" -d '{"username":"user1","password":"password2"}' http://192.168.0.103:8080/session.php
    // {"message":"sesión fallida","isValid":false}
    @POST("session.php") // Reemplaza "endpoint" con la URL del endpoint POST de tu API
    suspend fun postSession(@Body loginRequest: LoginRequest): ApiResponse // La respuesta será un String del JSON
}
