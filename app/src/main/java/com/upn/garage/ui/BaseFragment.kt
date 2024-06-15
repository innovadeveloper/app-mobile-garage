package com.upn.garage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {

    var activityCallback : OnToGoNewActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as? OnToGoNewActivity
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString() + " must implement ToolbarListener")
        }
    }


    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun onNextActivity(cls: Class<*>, bundle : Bundle?, isFinish : Boolean) {
        var intent = Intent(requireActivity(), cls)
        bundle?.let {
            intent.putExtras(bundle)
        }
        startActivity(intent)
//        overridePendingTransition(R.anim.slide_in_right, R.anim.no_animation);
        if (isFinish)
        {
            requireActivity().finish()
        }
    }

}