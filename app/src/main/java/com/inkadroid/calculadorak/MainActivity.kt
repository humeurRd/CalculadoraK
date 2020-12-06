package com.inkadroid.calculadorak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/*
*  TID41M
* Eduardo Carrera Sánchez | 1119150117
* Héctor Alejandro Chavira Muñoz | 1119150101
* */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    var ValorA = ""
    var ValorB = ""
    var operador = ' '
    val cont = ""
    val decimal = false
    var dato: Button? = null
    var hayPunto = false
    var a: Double = 0.toDouble()
    private lateinit var txtResultado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ENLACES Y RESPUESTA A EVENTOS
        txtResultado = findViewById<View>(R.id.txtResultado) as TextView
        var btn0 = findViewById<View>(R.id.btn0) as Button
        var btn1 = findViewById<View>(R.id.btn1) as Button
        var btn2 = findViewById<View>(R.id.btn2) as Button
        var btn3 = findViewById<View>(R.id.btn3) as Button
        var btn4 = findViewById<View>(R.id.btn4) as Button
        var btn5 = findViewById<View>(R.id.btn5) as Button
        var btn6 = findViewById<View>(R.id.btn6) as Button
        var btn7 = findViewById<View>(R.id.btn7) as Button
        var btn8 = findViewById<View>(R.id.btn8) as Button
        var btn9 = findViewById<View>(R.id.btn9) as Button
        var btnSuma = findViewById<View>(R.id.btnSuma) as Button
        var btnResta = findViewById<View>(R.id.btnResta) as Button
        var btnDivision = findViewById<View>(R.id.btnDivision) as Button
        var btnMultiplicacion = findViewById<View>(R.id.btnMultiplicacion) as Button
        var btnPotenciacion = findViewById<View>(R.id.btnPotenciacion) as Button
        var btnRaiz = findViewById<View>(R.id.btnRaiz) as Button
        var btnIgual = findViewById<View>(R.id.btnIgual) as Button
        var btnBorrar = findViewById<View>(R.id.btnBorrar) as Button
        var btnPunto = findViewById<View>(R.id.btnPunto) as Button
        var btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button
        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnSuma.setOnClickListener(this)
        btnResta.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
        btnMultiplicacion.setOnClickListener(this)
        btnPotenciacion.setOnClickListener(this)
        btnRaiz.setOnClickListener(this)
        btnIgual.setOnClickListener(this)
        btnBorrar.setOnClickListener(this)
        btnPunto.setOnClickListener(this)
        btnLimpiar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                //se pulso algun numero
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> numero(v)
                //ahora codificamos los botones de las operaciones
                R.id.btnSuma, R.id.btnResta, R.id.btnDivision, R.id.btnMultiplicacion,
                R.id.btnPotenciacion -> boton(v)
                //limpiar y borrar
                R.id.btnLimpiar, R.id.btnBorrar -> limpiar()
                //igual o resultado
                R.id.btnIgual -> resultado()
                R.id.btnPunto -> punto(v)
            }
        }
    }

    fun numero(v: View) {
        //saber que boton se pulso
        dato = v as Button
        //extraer el texto del boton y colocarlos en ValorA
        ValorA = ValorA + dato!!.text
        //poner en la caja de texto el numero que se pulso ValorA
        txtResultado.setText(ValorA)
    }

    fun boton(v: View) {
        //saber que boton se pulso
        dato = v as Button
        operador = dato!!.text[0]
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
    }

    fun limpiar() {
        ValorA = ""
        ValorB = ""
        txtResultado.setText("")
    }

    fun resultado() {
        var resultado = 0.0
        val a: Double
        val b: Double
        if (operador == '+') {
            resultado = ValorB.toDouble() + ValorA.toDouble()
        } else if (operador == '-') {
            resultado = ValorB.toDouble() - ValorA.toDouble()
        } else if (operador == '/') {
            resultado = ValorB.toDouble() / ValorA.toDouble()
        } else if (operador == '*') {
            resultado = ValorB.toDouble() * ValorA.toDouble()
        } else if (operador == '^') {
            a = ValorB.toDouble()
            b = ValorA.toDouble()
            resultado = Math.pow(a, b)
        }
        txtResultado!!.text = resultado.toString()
        ValorA = resultado.toString()
        ValorB = ""
    }

    fun punto(v: View) {
        dato = v as Button
        a = ValorA.toDouble()
        if (a % 1 == 0.0) {
            ValorA += dato!!.text
            txtResultado!!.text = ValorA
        } else if (a % 1 != 0.0) {
            hayPunto = true
        }
    }
}