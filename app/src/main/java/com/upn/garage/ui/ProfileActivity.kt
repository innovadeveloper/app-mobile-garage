package com.upn.garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upn.garage.R
import com.upn.garage.databinding.LoginActivityBinding
import com.upn.garage.databinding.ProfileActivityBinding
import com.upn.garage.databinding.RegisterActivityBinding
import com.upn.garage.domain.ext.showToast

class ProfileActivity : BaseActivity(){

    lateinit var binding : ProfileActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {
            this.showToast("Editar pérfil .. soon")
        }

        binding.btnReturn.setOnClickListener {
            super.onNextActivity(cls = HomeActivity::class.java, bundle = null, isFinish = true)
        }
    }
}