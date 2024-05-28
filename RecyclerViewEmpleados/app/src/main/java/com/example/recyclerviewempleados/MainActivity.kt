package com.example.recyclerviewempleados

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewempleados.adapters.adapterEmpleado
import com.example.recyclerviewempleados.models.empleados

class MainActivity : AppCompatActivity() {
    // lateinit es para decir que lo va a inicializar despues
   lateinit var listaEmpleados: MutableList<empleados>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // se agregan los elemntos
        // existen dos formas
        // 1. se pude crear una lista creando un objeto de tipo empleado y luego agregando  mas larga

       listaEmpleados= mutableListOf()

        var empleado= empleados("Wilfer", "instructor")
        listaEmpleados.add(empleado)

        // 2. se puede crear una lista esta es mas corta ya que crea el objeto dentro de la lista
        listaEmpleados.add(empleados("Carlos","Aprendiz"))
        listaEmpleados.add(empleados("Wilfer","Intructor"))
        listaEmpleados.add(empleados("Maria","Intructor"))
        listaEmpleados.add(empleados("David","Aprendiz"))
        listaEmpleados.add(empleados("Carlos","Intructor"))
        listaEmpleados.add(empleados("Marcos","Aprendiz"))
        listaEmpleados.add(empleados("Antonio","Intructor"))
        listaEmpleados.add(empleados("Serdio","Intructor"))
        listaEmpleados.add(empleados("Santiago","Aprendiz"))

        //obtenemos la lista de datos quemados
        //llenar el recycleView
        //se crea y se asocia una variable con el objeto de la vista
        var recycler=findViewById<RecyclerView>(R.id.RVEmpleado)
        recycler.layoutManager= LinearLayoutManager(applicationContext)
        // se crea el adaptador
        var adapterEmpleado= adapterEmpleado(listaEmpleados,applicationContext)
        //se asocia el adaptador con el objeto
        recycler.adapter=adapterEmpleado


    }
}