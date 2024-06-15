package com.upn.garage.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upn.garage.R
import com.upn.garage.databinding.LoginActivityBinding
import com.upn.garage.databinding.MapActivityBinding
import com.upn.garage.databinding.RegisterActivityBinding

class MapActivity : BaseActivity(){

    lateinit var binding : MapActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MapActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}