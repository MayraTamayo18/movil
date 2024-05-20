package com.example.cambioactivity

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // vercion sencilla o larga
        //definir el boton
        // var btnactividad2: Button  // boton para el cambio de actividad

        // asignamos
        //btnactividad2=findViewById<Button>(R.id.btnCambioActivity2)

        // accion al darle click
        // btnactividad2.setOnClickListener{
        //para hacer cambio de activity
        /*
            se confogura el intent, es el intento de ejecutar una actividad
            se asigna cual es la actividad que se va a ejecutar
            ejemplo activity
            var intent= intent(application,activity2::class.java)
            * */
        //var intent= Intent(application,activity2::class.java)
        //startActivity(intent)
        // }
    }
        //Vercion corta
        fun cambioActivity1(View: View){
            // se configura el cambio CTIVITY
        var intent=Intent(application,activity2::class.java)
        // se ejecuta la actividad
        startActivity(intent)
        }
    fun cambioActivity2(view: View){
        //segundo boton
        /*
        * para enviar informacion entre dos ectivity se utiliza el put
        * extra intent.putExtra("nombre_variable","valor")
        * */
        var txtNombre=findViewById<EditText>(R.id.txtNombre)
        var intent=Intent(application,activity3::class.java)
        // se crea un put para extraer por cada dato que se requiere
        intent.putExtra("nombre", txtNombre.text.toString())
        startActivity(intent)
    }



}