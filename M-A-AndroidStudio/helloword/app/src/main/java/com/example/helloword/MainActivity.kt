package com.example.helloword

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        // definicion de los objetos
        var btnIngresar: Button
        var txtNombre:TextView
        // asignacion del valor
        btnIngresar=findViewById(R.id.btnIngresar)
        txtNombre=findViewById(R.id.txtNombre)
        //configurar la accion al presionar el boton ingresar
        btnIngresar.setOnClickListener{
            var nombre= txtNombre.text
            //se utiliza el mensaje toast para mostrar el saludo
            Toast.makeText(applicationContext, //contexto
                "Hols mi querido cliente ${nombre}",//texto a mostrar
                Toast.LENGTH_SHORT//duracion del mensaje
            ).show()
        }
    }
}