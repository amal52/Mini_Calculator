package com.first.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var operation: Char = ' '
    private var resultValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1: EditText = findViewById(R.id.txt1)
        val num2: EditText = findViewById(R.id.txt2)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val result: TextView = findViewById(R.id.ans)


        val operationButtons = listOf(btn1, btn2, btn3, btn4)
        operationButtons.forEach { button ->
            button.setOnClickListener {
                operation = when (button.id) {
                    R.id.btn1 -> '+'
                    R.id.btn2 -> '-'
                    R.id.btn3 -> '*'
                    R.id.btn4 -> '/'
                    else -> ' '
                }
            }
        }

        btn5.setOnClickListener {
            val convNum1 = num1.text.toString().toDoubleOrNull()
            val convNum2 = num2.text.toString().toDoubleOrNull()
            if (convNum1 != null && convNum2 != null) {
                when (operation) {
                    '+' -> resultValue = convNum1 + convNum2
                    '-' -> resultValue = convNum1 - convNum2
                    '*' -> resultValue = convNum1 * convNum2
                    '/' -> {
                        if (convNum2 != 0.0) {
                            resultValue = convNum1 / convNum2
                        }
                    }
                }
                result.text = resultValue.toString()
            } else {
                result.text = ""
            }
        }
    }
}