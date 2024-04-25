package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // creamos una variable que almacene nuestras operaciones esta va a ser de tipo entero
    // 0-> nada 1->suma 2->resta 3->multiplicacion 4->divicion
    var operacion: Int=0
    // variable para los 0.0
    var numero1: Double = 0.0
    // lateinit var-> permite inicializar una propiedad no anulable
    // se reaklizo para poder utilizarlos en cualquien funcion sin
    //necesidad de volver a declararlos
    lateinit var tv1: TextView
    lateinit var  tv2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        // creamos nuestro boton borra
        val btnBorrar : Button=findViewById(R.id.btnBorrar)
        val btnIgual : Button=findViewById(R.id.btnIgual)

        btnIgual.setOnClickListener{
            var numero2: Double=tv2.text.toString().toDouble()
            var respuesta: Double=0.0
            when(operacion) {
                1 -> respuesta = numero1 + numero2
                2-> respuesta= numero1 - numero2
                3-> respuesta= numero1 * numero2
                4-> respuesta= numero1 / numero2
            }
            tv2.setText(respuesta.toString())
            tv1.setText("")
        }
        btnBorrar.setOnClickListener{
            tv1.setText("")
            tv2.setText("")
            numero1= 0.0
            operacion= 0
        }
    }
    // creamos una funcion para los botonella la cual va a tener una parametro de entrada
    // view ->( se refiere lo vamos a mandar a llamar con un elemento de la vista (resive una vista))
    fun digitos(view: View){
        // creamos una variable para llamar o traer el textView 2(tv2)
        // val tv2: TextView=findViewById(R.id.tv2)-> gracias a lateinit var ya no necesitamos volver a declarar
        //  creamos una variable para el valor llamar o traer el valornumerico
        // se convierte el num2 a el tipo de dato String y se llama tv2
        // el texto lo convertimos a un string
        var num2: String=tv2.text.toString()
        // creamos un when para mandar a llamar el elemento view id
        // para darle funcionalidad a los botones y que aparesca los numeros del boton en el textView tv2
        when (view.id){
            R.id.btn0->tv2.setText(num2 + "0")
            R.id.btn1->tv2.setText(num2 + "1")
            R.id.btn2->tv2.setText(num2 + "2")
            R.id.btn3->tv2.setText(num2 + "3")
            R.id.btn4->tv2.setText(num2 + "4")
            R.id.btn5->tv2.setText(num2 + "5")
            R.id.btn6->tv2.setText(num2 + "6")
            R.id.btn7->tv2.setText(num2 + "7")
            R.id.btn8->tv2.setText(num2 + "8")
            R.id.btnPunto->tv2.setText(num2 + ".")

            // OJITO: en la vista se le aplica tambien el onclick a cada boton
            // en la vista se le quita a los textView tv el texto y se coloca en en hint
            // se utiliza para mostrar una etiqueta de texto descriptivo en el elemento cuando esta vacio

        }
    }
    // creamos un afuncion para la suma
    fun clicOperacion(view: View){
       numero1= tv2.text.toString().toDouble()
        var tv2_text: String= tv2.text.toString()
        //para cuando mandamos los unumero al texViw tv1 hay que actuaalizar el tv2 en 0.0
        tv2.setText("")
        when(view.id){
            // cuando el que llamen sea el boton sumar
            R.id.btnSuma->{
                // al darle en el boton de suma ademas de enviarle  el signo +
                // tambien le decimos a nuestro programa que va a realizar la operacion de suma
                tv1.setText(tv2_text + "+")
                operacion= 1
            }
            R.id.btnResta->{
                tv1.setText(tv2_text + "-")
                operacion=2
            }
            R.id.btnMultiplicacion->{
                tv1.setText(tv2_text + "*")
                operacion=3
            }
            R.id.btnDivision->{
                tv1.setText(tv2_text + "/")
                operacion=4
            }
        }
    }

}