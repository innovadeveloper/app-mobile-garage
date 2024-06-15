package com.upn.garage.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.upn.garage.R
import com.upn.garage.databinding.HomeActivityBinding
import com.upn.garage.databinding.LoginActivityBinding
import com.upn.garage.domain.ext.showToast
import com.upn.garage.domain.utils.Utils

class HomeActivity : BaseActivity(){

    lateinit var binding : HomeActivityBinding
    // Crear una instancia de tu Fragment
    val garageFragment : GarageFragment = GarageFragment()
    val profileFragment : ProfileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cvMap.setOnClickListener {
            this.showToast("To go to map... soon")
        }
        binding.cvGarage.setOnClickListener {
            changeView(garageFragment)
        }
        binding.cvProfile.setOnClickListener {
            changeView(profileFragment)
        }

        changeView(garageFragment)
    }

    fun changeView(fragment: BaseFragment){
        // Obtener el FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager
        // Iniciar una transacción de fragmentos
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        // Reemplazar el contenido del FrameLayout con el Fragment
        fragmentTransaction.replace(R.id.fl, fragment)
        // Confirmar la transacción
        fragmentTransaction.commit()
    }

}