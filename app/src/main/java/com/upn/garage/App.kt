package com.upn.garage

import android.app.Application
import com.upn.garage.domain.dto.User

class App : Application() {

    companion object{
        var SESSION_ID = 0L
        var CURRENT_USER : User? = null

    }

    override fun onCreate() {
        super.onCreate()

    }
}