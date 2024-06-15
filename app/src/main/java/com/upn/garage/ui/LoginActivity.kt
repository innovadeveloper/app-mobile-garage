package com.upn.garage.ui

import android.os.Bundle
import com.upn.garage.data.network.RetrofitInstance
import com.upn.garage.data.sqlite.dao.GarageDao
import com.upn.garage.data.sqlite.dao.SessionDAO
import com.upn.garage.databinding.LoginActivityBinding
import com.upn.garage.domain.dto.GarageEntity
import com.upn.garage.domain.dto.LoginRequest
import com.upn.garage.domain.dto.SessionEntity
import com.upn.garage.domain.ext.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : BaseActivity(){

    lateinit var binding : LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            super.onNextActivity(cls = HomeActivity::class.java, bundle = null, isFinish = true)
//            createUserEntity()
//            createNewSessionEntity()
//            if(binding.etUsername.text.isNullOrBlank() ||
//                binding.etPassword.text.isNullOrBlank()){
//                this@LoginActivity.showToast("¡Completa las casillas!")
//                return@setOnClickListener
//            }
//
//            val loginRequest = LoginRequest(
//                username = binding.etUsername.text.toString(),
//                password = binding.etPassword.text.toString()
//            )
//
//            GlobalScope.launch(Dispatchers.IO) {
//                try {
//                    val response = RetrofitInstance.apiService.postSession(loginRequest)
//                    withContext(Dispatchers.Main) {
//                        if(response.isValid){
//                            super.onNextActivity(cls = HomeActivity::class.java, bundle = null, isFinish = true)
//                        }else{
//                            this@LoginActivity.showToast(response.message)
//                        }
//                    }
//                } catch (e: Exception) {
//                    println("Error: ${e.message}")
//                }
//            }
        }

        binding.tvAccountRegister.setOnClickListener {
            super.onNextActivity(cls = RegisterActivity::class.java, bundle = null, isFinish = true)
        }
    }

    fun createUserEntity(){
        val garageEntityDao = GarageDao(this)

        // INSERT SINGLE ENTITY
// Para insertar un solo elemento
        val garage = GarageEntity(username = "usuario123", position = "A1", state = "libre")
        val newRowId = garageEntityDao.insertGarageEntity(garage)

        // INSERT LIST
        // Para insertar varios elementos
        val garages = listOf(
            GarageEntity(username = "usuario124", position = "A2", state = "ocupado"),
            GarageEntity(username = "usuario125", position = "A3", state = "libre")
        )
        val newRowIds = garageEntityDao.insertGarageEntitys(garages)
        // SELECT * FROM
        val garagePlaces = garageEntityDao.garageEntitiesList()

        for (lugar in garagePlaces) {
            println("ID: ${lugar.id}, Username: ${lugar.username}, Position: ${lugar.position}, State: ${lugar.state}")
        }
    }

    fun createNewSessionEntity(){
        val sessionDAO = SessionDAO(this)

// Para insertar una nueva sesión
        val newSession = SessionEntity(username = "usuario123", password = "password123", createdAt = "2024-06-14", state = "active")
        val newSessionId = sessionDAO.insertSessionEntity(newSession)

// Para recuperar todas las sesiones
        val allSessions = sessionDAO.getAllSessionEntitys()
        for (session in allSessions) {
            println("ID: ${session.id}, Username: ${session.username}, CreatedAt: ${session.createdAt}, State: ${session.state}")
        }

// Para actualizar el estado de una sesión
        val updatedRows = sessionDAO.updateSessionEntityState(newSessionId.toInt(), "inactive")
        println("Updated rows: $updatedRows")

        // Para recuperar todas las sesiones
        val allSessions2 = sessionDAO.getAllSessionEntitys()
        for (session in allSessions2) {
            println("ID: ${session.id}, Username: ${session.username}, CreatedAt: ${session.createdAt}, State: ${session.state}")
        }

    }
    
    
}