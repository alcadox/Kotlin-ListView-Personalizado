package com.example.ejerciciolistview

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciolistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adaptadorPersonas: MiAdaptadorPersonas

    private val listaPersonas = mutableListOf(
        Personas("Alejandro", "Castillo Durillo", "Hombre", "DAM"),
        Personas("Avril", "Merino Moreno", "Mujer", "DAW"),
        Personas("Aarón", "Quevedo Latorre", "Hombre", "ASIR")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptadorPersonas = MiAdaptadorPersonas(this, R.layout.personas_item, listaPersonas)

        binding.listViewPersonas.adapter = adaptadorPersonas

        binding.listViewPersonas.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->

            val persona = listaPersonas[position]

            Toast.makeText(
                this,
                "${persona.nombre} - ${persona.apellidos}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.listViewPersonas.setOnItemClickListener { parent, view, position, id ->
            val personaSeleccionada = parent.getItemAtPosition(position) as Personas

            val intent = Intent(this, ActivityModulos::class.java)

            intent.putExtra(ActivityModulos.CICLO_SELECCIONADO, personaSeleccionada.ciclo)

            startActivity(intent)
        }
    }
}