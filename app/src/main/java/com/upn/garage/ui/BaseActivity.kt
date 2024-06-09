/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.upn.garage.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


abstract class BaseActivity : AppCompatActivity(), OnToGoNewActivity {

//    var closureAppBackground : (()-> Unit)? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
//        makeStatusBarTransparent2()
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart(){
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

   fun Activity.makeStatusBarTransparent() {
//        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
       window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       supportActionBar?.hide()

       window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
       val attrib = window.attributes
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
           attrib.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
       }
   }

    fun Activity.makeStatusBarTransparent2() {
//        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()

        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        val attrib = window.attributes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            attrib.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
    }


    override fun onNextActivity(cls: Class<*>, bundle : Bundle?, isFinish : Boolean, context: Context?) {
        var intent = Intent(this, cls)
        bundle?.let {
            intent.putExtras(bundle)
        }
        startActivity(intent)
        if (isFinish)
        {
            finish()
        }
    }


    override fun onNextActivity(cls: Class<*>, bundle : Bundle?, isFinish : Boolean) {
        var intent = Intent(this, cls)
        bundle?.let {
            intent.putExtras(bundle)
        }
        startActivity(intent)
//        overridePendingTransition(R.anim.slide_in_right, R.anim.no_animation);
        if (isFinish)
        {
            finish()
        }
    }


}