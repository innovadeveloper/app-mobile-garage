package com.upn.garage.data.network

import com.upn.garage.domain.dto.ApiResponse
import com.upn.garage.domain.dto.GaragePosition
import com.upn.garage.domain.dto.LoginRequest
import com.upn.garage.domain.dto.LoginResponse
import com.upn.garage.domain.dto.LogoutRequest
import com.upn.garage.domain.dto.SessionEntity
import com.upn.garage.domain.dto.UpdateGaragePositionRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    // curl -X POST -H "Content-Type: application/json" -d '{"username":"kenny","password":"kenny"}' http://192.168.0.105:8080/session.php
    // curl -X POST -H "Content-Type: application/json" -d '{"username":"kenny","password":"prueba"}' http://192.168.0.105:8080/session.php
    // {"message":"sesión fallida","isValid":false, "id" : 1}
    @POST("session.php") // Reemplaza "endpoint" con la URL del endpoint POST de tu API
    suspend fun postSession(@Body loginRequest: LoginRequest): LoginResponse // La respuesta será un String del JSON

    // curl -X POST -H "Content-Type: application/json" -d '{"id":14}' http://192.168.0.105:8080/logout.php
    @POST("logout.php") // Reemplaza "endpoint" con la URL del endpoint POST de tu API
    fun postLogout(@Body logoutRequest: LogoutRequest): Call<ApiResponse> // La respuesta será un String del JSON

    // curl -X POST -H "Content-Type: application/json"  http://192.168.0.105:8080/list_garage.php
    //[{"id":"1","username":"user1","position":"1","state":"RESERVADO"},{"id":"2","username":null,"position":"2","state":"DISPONIBLE"},{"id":"3","username":null,"position":"3","state":"DISPONIBLE"},{"id":"4","username":null,"position":"4","state":"ROW"},{"id":"5","username":null,"position":"5","state":"DISPONIBLE"},{"id":"6","username":null,"position":"6","state":"DISPONIBLE"},{"id":"7","username":null,"position":"7","state":"DISPONIBLE"},{"id":"8","username":null,"position":"8","state":"ROW"},{"id":"9","username":null,"position":"9","state":"DISPONIBLE"},{"id":"10","username":null,"position":"10","state":"DISPONIBLE"},{"id":"11","username":null,"position":"11","state":"DISPONIBLE"}]
    @POST("list_garage.php") // Reemplaza "endpoint" con la URL del endpoint POST de tu API
    suspend fun getGaragePositionList(): List<GaragePosition> // La respuesta será un String del JSON

}
