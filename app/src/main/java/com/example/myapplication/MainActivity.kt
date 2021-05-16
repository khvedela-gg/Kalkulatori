package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var delButton: Button
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.resultTextView = findViewById(R.id.resultTextView)
        this.delButton = findViewById(R.id.DEL)
    }

    fun numberClick(clickedView: View) {
        if (clickedView is Button) {
            val number: String = clickedView.text.toString()
            var result: String = this.resultTextView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = "$result$number"
        }
    }

    fun operationClick(view: View) {
        if (view is Button) {

            if (resultTextView.text.isNotEmpty()) {
                operand = resultTextView.text.toString().toDouble()
            }

            this.operation = view.text.toString()
            this.resultTextView.text = ""

        }
    }

    fun equalsClick(view: View) {
        val secOperandText: String = this.resultTextView.text.toString()
        var secOperand = 0.0

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toDouble()
        }

        when (this.operation) {
            "+" -> {

                if((this.operand + secOperand).compareTo((this.operand + secOperand).toInt()) == 0) {
                    this.resultTextView.text = (this.operand + secOperand).toInt().toString()
                } else {
                    this.resultTextView.text = (this.operand + secOperand).toString()
                }
            }
            "-" -> {
                if((this.operand - secOperand).compareTo((this.operand - secOperand).toInt()) == 0) {
                    this.resultTextView.text = (this.operand - secOperand).toInt().toString()
                } else {
                    this.resultTextView.text = (this.operand - secOperand).toString()
                }
            }
            "*" -> {
                if((this.operand * secOperand).compareTo((this.operand * secOperand).toInt()) == 0) {
                    this.resultTextView.text = (this.operand * secOperand).toInt().toString()
                } else {
                    this.resultTextView.text = (this.operand * secOperand).toString()
                }
            }
            "/" -> {
                if((this.operand / secOperand).compareTo((this.operand / secOperand).toInt()) == 0) {
                    this.resultTextView.text = (this.operand / secOperand).toInt().toString()
                } else {
                    this.resultTextView.text = (this.operand / secOperand).toString()
                }
            }
        }
    }

    fun clearClick(view: View) {
        this.resultTextView.text = ""
    }

    fun delClick(view: View) {
        this.resultTextView.text = this.resultTextView.text.dropLast(1)
    }

}