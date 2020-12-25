package com.example.calcng

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {
    private var firstVariable:Double = 0.0
    private var secondVariable:Double = 0.0
    private var operation:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    fun delete(view: View){
        val value:String = resultTextVeiw.text.toString()
        if (value.isNotEmpty()) {
            resultTextVeiw.text = value.substring(0, value.length - 1)
        }
    }
    fun divide(view: View){
        val value = resultTextVeiw.text.toString()
        if (value.isNotEmpty()) {
            firstVariable = value.toDouble()
            operation = ":"
            resultTextVeiw.text = ""
        }
    }
    fun plus(view: View){
        val value = resultTextVeiw.text.toString()
        if (value.isNotEmpty()) {
            firstVariable = value.toDouble()
            operation = "+"
            resultTextVeiw.text = ""
        }
    }
    fun minus(view: View){
        val value = resultTextVeiw.text.toString()
        if (value.isNotEmpty()) {
            firstVariable = value.toDouble()
            operation = "-"
            resultTextVeiw.text = ""
        }
    }
    fun multiply(view: View){
        val value = resultTextVeiw.text.toString()
        if (value.isNotEmpty()) {
            firstVariable = value.toDouble()
            operation = "x"
            resultTextVeiw.text = ""
        }
    }
    fun dot(view: View){
        if ("." !in resultTextVeiw.text.toString() && resultTextVeiw.text.toString().isNotEmpty())
        resultTextVeiw.text = resultTextVeiw.text.toString() + "."
    }
    fun result(view: View){
        val value = resultTextVeiw.text.toString()
        if (value.isNotEmpty()) {
            secondVariable = value.toDouble()
        }
        var result:Double = 0.0
        if (operation == ""){
            resultTextVeiw.text = resultTextVeiw.text.toString()
        }
        if (operation == ":" && secondVariable != 0.0){
            result = firstVariable / secondVariable
        }
        if (operation == "x"){
            result = firstVariable * secondVariable
        }
        if (operation == "+"){
            result = firstVariable + secondVariable
        }
        if (operation == "-"){
            result = firstVariable - secondVariable
        }

        resultTextVeiw.text = result.toString()
        operation = ""
        firstVariable = 0.0
        secondVariable = 0.0
    }


    override fun onClick(v: View?) {
        val button:Button = v as Button
        resultTextVeiw.text = resultTextVeiw.text.toString() + button.text.toString()
    }
}