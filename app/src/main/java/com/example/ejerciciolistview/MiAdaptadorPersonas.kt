package com.example.ejerciciolistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ejerciciolistview.databinding.PersonasItemBinding

class MiAdaptadorPersonas (
    miContext: Context,
    resource: Int,
    private val listaPersonas: List<Personas>
) : ArrayAdapter<Personas>(miContext, resource, listaPersonas){

    companion object{
        private val iconosSexo = mapOf(
            "Hombre" to R.drawable.hombre,
            "Mujer" to R.drawable.mujer
        )
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = if (convertView == null){
            PersonasItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        } else{
            PersonasItemBinding.bind(convertView)
        }

        val personaActual: Personas = listaPersonas[position]

        binding.textViewNombre.text = personaActual.nombre
        binding.textViewApellidos.text = personaActual.apellidos
        binding.textViewCiclo.text = personaActual.ciclo

        binding.imageViewAvatar.setImageResource(
            iconosSexo[personaActual.sexo] ?: R.drawable.interrogacion
        )
        return binding.root
    }
}