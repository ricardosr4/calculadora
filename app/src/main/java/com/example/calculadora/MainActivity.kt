package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operation: Int = 0    // Variable para almacenar el tipo de operación (+, -, *, /)
    private var numero1: Double = 0.0   // Variable para almacenar el primer número en la operación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnborrar: Button = binding.btnborrar
        val btnigual: Button = binding.btnigual

        btnigual.setOnClickListener {
            val numero2: Double = binding.tvNum2.text.toString().toDouble()
            var response = 0.0
// Realiza la operación correspondiente según el valor de 'operation'
            when (operation) {
                1 -> {
                    response = numero1 + numero2
                }

                2 -> {
                    response = numero1 - numero2
                }

                3 -> {
                    response = numero1 * numero2
                }

                4 -> {
                    response = numero1 / numero2
                }
            }

            // Eliminar ceros innecesarios al final del número y muestra el resultado
            val resultadoSinCeros = response.toString().trimEnd('0').trimEnd('.')

            binding.tvNum2.text = resultadoSinCeros
            binding.tvNum1.text = ""
        }
// Limpia los campos y reinicia las variables
        btnborrar.setOnClickListener {
            binding.tvNum1.text = ""
            binding.tvNum2.text = ""
            numero1 = 0.0
            operation = 0
        }
    }

    fun presionarDigito(view: View) {
        val num2: String = binding.tvNum2.text.toString()
// Limpia los campos y reinicia las variables
        when (view.id) {
            R.id.btn0 -> binding.tvNum2.text = num2 + "0"
            R.id.btn1 -> binding.tvNum2.text = num2 + "1"
            R.id.btn2 -> binding.tvNum2.text = num2 + "2"
            R.id.btn3 -> binding.tvNum2.text = num2 + "3"
            R.id.btn4 -> binding.tvNum2.text = num2 + "4"
            R.id.btn5 -> binding.tvNum2.text = num2 + "5"
            R.id.btn6 -> binding.tvNum2.text = num2 + "6"
            R.id.btn7 -> binding.tvNum2.text = num2 + "7"
            R.id.btn8 -> binding.tvNum2.text = num2 + "8"
            R.id.btn9 -> binding.tvNum2.text = num2 + "9"
            R.id.btnpunto -> binding.tvNum2.text = num2 + "."
        }
        //hola ricardo
    }

    fun clicOperacion(view: View) {
        numero1 = binding.tvNum2.text.toString().toDouble()
        val num2Text: String = binding.tvNum2.text.toString()
        binding.tvNum2.text = ""
        // Actualiza la pantalla con la operación seleccionada y el número actual
        when (view.id) {
            R.id.btnsumar -> {
                binding.tvNum1.text = num2Text + "+"
                operation = 1
            }

            R.id.btnrestar -> {
                binding.tvNum1.text = num2Text + "-"
                operation = 2
            }

            R.id.btnmult -> {
                binding.tvNum1.text = num2Text + "*"
                operation = 3
            }

            R.id.btndiv -> {
                binding.tvNum1.text = num2Text + "/"
                operation = 4
            }
        }
    }
}





