package com.example.interface5

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interface5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var pueblos= emptyArray<String>()
    lateinit var arrayAdapter: ArrayAdapter<*>
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ayuda a enlasar la vista por medio del binding
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //array que contiene los pueblos

        val pueblos= arrayOf(
            "Veracruz",
            "Tabasco",
            "Chiapas",
            "campeche",
            "QuintanRoo"
        )
        // variable para inicializar nuestro array<adapter

        var itemsAdapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pueblos)
        binding.listaPueblos.adapter= itemsAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}