package com.example.recyclerviewempleados.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewempleados.R
import com.example.recyclerviewempleados.models.empleados

// esta clase es la encargadad de cargar los datos a el recyclerView

// para crear o intanciar  esta clase necesita unos parametros
// los cuales son: lista de  elemetos, contexto de la aplicacion

// esta clase debe heredar de la clase RcyclerView.Adapter
// para heredar se utiliza: y la clase deonde se va a heredar

class adapterEmpleado
    (var listaEmpleado:List<empleados>,
     var context:Context): RecyclerView.Adapter<adapterEmpleado.MyHolder>()
{
    // se crea la clase Myholder-> se crea para asociar los elemnetos de la vistan item con
    inner  class  MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        // dentro de la clase MyHonder se crea las variables y se asocian los objetos de la vista item

        lateinit var lblNombre: TextView
        lateinit var lblCargo: TextView

        //vamos  a asociar las dos variables anteriores
        init {
            lblNombre=itemView.findViewById(R.id.lblNombre)
            lblCargo=itemView.findViewById(R.id.lblCargo)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterEmpleado.MyHolder {
        // crear la vista
        var itemView= LayoutInflater.from(context).inflate(R.layout.item_employed,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterEmpleado.MyHolder, posicion: Int) {
      // vamos a unir  el Holder (poseor) con la vista
        // obtenemso el registro
        var empleados= listaEmpleado[posicion]

        //asignar valores
        holder.lblNombre.text=empleados.nombre
        holder.lblCargo.text=empleados.cargo
    }

    // el metodo getItemCount retorna el numero de elmentos de la lista
    override fun getItemCount(): Int {
        return listaEmpleado.size
    }

}