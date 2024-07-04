package com.upn.garage.infrastructure.service

import android.os.AsyncTask
import androidx.core.util.Consumer

class ProfileAsyncTask : AsyncTask<Void, Void, String>() {

    override fun onPreExecute() {
        super.onPreExecute()
        // Aquí puedes mostrar un ProgressDialog o realizar otra tarea previa
    }

    override fun doInBackground(vararg params: Void?): String {
        // Realizar la tarea en segundo plano (e.g., una operación de red o una tarea intensiva)
        // Simulamos una tarea de larga duración con un sleep
        Thread.sleep(3000)
        return "Tarea completada"
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        // Actualizar la interfaz de usuario con el resultado
//        textView.text = result
    }
}