package com.upn.garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upn.garage.R
import com.upn.garage.databinding.LoginActivityBinding
import com.upn.garage.databinding.RegisterActivityBinding

class RegisterActivity : BaseActivity(){

    lateinit var binding : RegisterActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvReturn.setOnClickListener {
            super.onNextActivity(cls = LoginActivity::class.java, bundle = null, isFinish = true)
        }
    }
}