package com.upn.garage.ui

import android.content.Context
import android.os.Bundle

interface OnToGoNewActivity {
    fun onNextActivity(cls : Class<*>, bundle : Bundle?, isFinish : Boolean = false)
    fun onNextActivity(cls : Class<*>, bundle : Bundle?, isFinish : Boolean = false, context : Context? = null)
}
