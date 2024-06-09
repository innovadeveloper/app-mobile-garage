package com.upn.garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upn.garage.R
import com.upn.garage.databinding.LoginActivityBinding

class LoginActivity : BaseActivity(){

    lateinit var binding : LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            super.onNextActivity(cls = HomeActivity::class.java, bundle = null, isFinish = true)
        }
    }
}