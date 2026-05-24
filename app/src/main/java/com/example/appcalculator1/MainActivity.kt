package com.example.appcalculator1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var tvDisplay: TextView

    var numero1 = 0.0
    var operacao = ""
    var esperandoSegundoNumero = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvDisplay = findViewById(R.id.tvDisplay)

        // botoes dos numeros
        findViewById<Button>(R.id.btn0).setOnClickListener {
            tvDisplay.append("0")
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            if (tvDisplay.text.toString() == "0" || tvDisplay.text.toString() == "Erro" ) {

                tvDisplay.text = "1"

            } else {

                tvDisplay.append("1")
            }
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "2"

            } else {

                tvDisplay.append("2")
            }
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "3"

            } else {

                tvDisplay.append("3")
            }
        }

        findViewById<Button>(R.id.btn4).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "4"

            } else {

                tvDisplay.append("4")
            }
        }

        findViewById<Button>(R.id.btn5).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "5"

            } else {

                tvDisplay.append("5")
            }
        }

        findViewById<Button>(R.id.btn6).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "6"

            } else {

                tvDisplay.append("6")
            }
        }

        findViewById<Button>(R.id.btn7).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "7"

            } else {

                tvDisplay.append("7")
            }
        }

        findViewById<Button>(R.id.btn8).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "8"

            } else {

                tvDisplay.append("8")
            }
        }

        findViewById<Button>(R.id.btn9).setOnClickListener {
            if (tvDisplay.text.toString() == "0") {

                tvDisplay.text = "9"

            } else {

                tvDisplay.append("9")
            }
        }

// BOTÃO +
        findViewById<Button>(R.id.btnAdd).setOnClickListener {

            numero1 = tvDisplay.text.toString().toDouble()

            operacao = "+"

            tvDisplay.append(" + ")

            esperandoSegundoNumero = true
        }

// BOTÃO =
        findViewById<Button>(R.id.btnEquals).setOnClickListener {

            val texto = tvDisplay.text.toString()

            // Se não tiver operação, não faz nada
            if (!texto.contains("+") &&
                !texto.contains("-") &&
                !texto.contains("*") &&
                !texto.contains("/")
            ) {
                return@setOnClickListener
            }

            val partes = texto.split(" ")

            // Se a conta ainda não estiver completa, não faz nada
            if (partes.size < 3) {
                return@setOnClickListener
            }

            val numero2 = partes[2].toDouble()

            var resultado = 0.0

            if (operacao == "+") {
                resultado = numero1 + numero2
            }

            if (operacao == "-") {
                resultado = numero1 - numero2
            }

            if (operacao == "*") {
                resultado = numero1 * numero2
            }

            if (operacao == "/") {
                if (numero2 == 0.0) {
                    tvDisplay.text = "Erro"
                    return@setOnClickListener
                }

                resultado = numero1 / numero2
            }

            // Resultado
            tvDisplay.text = resultado.toString()
        }

        // BOTÃO -
        findViewById<Button>(R.id.btnSubtract).setOnClickListener {
            numero1 = tvDisplay.text.toString().toDouble()
            operacao = "-"
            tvDisplay.append(" - ")
        }

        // BOTÃO *
        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            numero1 = tvDisplay.text.toString().toDouble()
            operacao = "*"
            tvDisplay.append(" * ")
        }

        // BOTÃO /
        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            numero1 = tvDisplay.text.toString().toDouble()
            operacao = "/"
            tvDisplay.append(" / ")
        }

        // BOTÃO C
        findViewById<Button>(R.id.btnClear).setOnClickListener {

            tvDisplay.text = "0"
        }
    }
}