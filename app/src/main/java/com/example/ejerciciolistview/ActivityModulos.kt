package com.example.ejerciciolistview
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciolistview.databinding.ActivityModulosBinding
import androidx.core.graphics.toColorInt
class ActivityModulos : AppCompatActivity() {

    private lateinit var bindin: ActivityModulosBinding
    companion object{
        const val CICLO_SELECCIONADO = "ciclo"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindin = ActivityModulosBinding.inflate(layoutInflater)
        setContentView(bindin.root)

        val ciclo = intent.getStringExtra(CICLO_SELECCIONADO).toString()

        when (ciclo) {
            "DAM" ->{
                bindin.root.setBackgroundColor("#b675ff".toColorInt())
                bindin.textViewIndicadorDeCiclo.text = "Estás en el ciclo DAM"
                bindin.imageViewCiclo.setImageResource(R.drawable.dam)
            }
            "DAW" -> {
                bindin.root.setBackgroundColor("#ff5436".toColorInt())
                bindin.textViewIndicadorDeCiclo.text = "Estás en el ciclo DAW"
                bindin.imageViewCiclo.setImageResource(R.drawable.daw)

            }
            "ASIR" -> {
                bindin.root.setBackgroundColor("#c1ff65".toColorInt())
                bindin.textViewIndicadorDeCiclo.text = "Estás en el ciclo ASIR"
                bindin.imageViewCiclo.setImageResource(R.drawable.asir)
            }
            else -> {
                bindin.root.setBackgroundColor(Color.WHITE)
                bindin.textViewIndicadorDeCiclo.text = "Error inesperado"
                bindin.imageViewCiclo.setImageResource(R.drawable.interrogacion)
            }
        }

        bindin.buttonVolver.setOnClickListener {
            finish()
        }
    }
}