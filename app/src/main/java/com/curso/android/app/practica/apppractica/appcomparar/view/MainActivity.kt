package com.curso.android.app.practica.apppractica.appcomparar.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.apppractica.appcomparar.R
import com.curso.android.app.practica.apppractica.appcomparar.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.texto.observe(this) {
            binding.textViewResultado.text = "${it.textoF}"
        }

        val editTextA = findViewById<EditText>(R.id.editTextA)
        val editTextB = findViewById<EditText>(R.id.editTextB)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)
        val botonComparacion = findViewById<Button>(R.id.botonComparacion)
        val  mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        botonComparacion.setOnClickListener {
            val textoA = editTextA.text.toString()
            val textoB = editTextB.text.toString()
            val resultado = mainViewModel.comparar(textoA, textoB)
            textViewResultado.text = resultado.toString()
        }
    }
}

