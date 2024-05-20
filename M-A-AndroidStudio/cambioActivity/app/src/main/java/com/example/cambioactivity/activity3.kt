package com.example.cambioactivity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnRegresar = findViewById<Button>(R.id.btnResgresar)
        btnRegresar.setOnClickListener {
            finish()
        }
        //para capturar la informacion por el extra se utiliza
        // inten.getTipoDatoExtra("nombre_de_la_variable")
        // ejemplo
        // para capturar un String
        // var nombre=intent.getStringExtrar("nombre")  capturar y mostrar el nombre
        var nombre=intent.getStringExtra("nombre")
        Toast.makeText(applicationContext,
            nombre,
            Toast.LENGTH_SHORT
        ).show()

    }
}