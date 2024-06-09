package com.upn.garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upn.garage.R
import com.upn.garage.databinding.HomeActivityBinding
import com.upn.garage.databinding.LoginActivityBinding
import com.upn.garage.domain.ext.showToast
import com.upn.garage.domain.utils.Utils

class HomeActivity : AppCompatActivity(){

    lateinit var binding : HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llToViewGarage.setOnClickListener {
            this.showToast("View Garage... soon")
        }
        binding.llToGoGarageMap.setOnClickListener {
            this.showToast("To go to map... soon")
        }
    }
}