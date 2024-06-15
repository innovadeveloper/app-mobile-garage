package com.upn.garage.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.upn.garage.App
import com.upn.garage.data.network.RetrofitInstance
import com.upn.garage.databinding.GarageFragmentBinding
import com.upn.garage.databinding.ProfileActivityBinding
import com.upn.garage.domain.constants.MATRIX_ITEM
import com.upn.garage.domain.dto.CarMatrixDTO
import com.upn.garage.domain.dto.LogoutRequest
import com.upn.garage.domain.ext.showToast
import com.upn.garage.infrastructure.service.MatrixService
import com.upn.garage.infrastructure.service.impl.MatrixServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.LinkedList
import java.util.Queue

class ProfileFragment : BaseFragment() {

    lateinit var binding : ProfileActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileActivityBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(requireActivity())
    }

    fun initView(context : Context){
        App.CURRENT_USER?.let {
            binding.tvFullName.text = it.fullName
            binding.tvUsername.text = it.username
            binding.tvState.text = it.state
            binding.tvCreateAt.text = it.createdAt
            binding.tvRoleName.text = it.role
        }
        binding.btnLogout.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = RetrofitInstance.apiService.postLogout(LogoutRequest(App.SESSION_ID))
                    withContext(Dispatchers.Main) {
                        context.showToast(response.message)
                        if(response.isValid)
                            super.onNextActivity(cls = LoginActivity::class.java, bundle = null, isFinish = true)
                    }
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }
        }
    }
}
