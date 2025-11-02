package es.etg.dam.pmdm.databridge.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm.databridge.data.Persona
import es.etg.dam.pmdm.databridge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarVistas()
    }

    private fun inicializarVistas() {
        binding.btnNavegar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val nombreTexto = binding.ettNombre.text.toString()
        val apellidoTexto = binding.ettApellido.text.toString()
        val edadTexto = binding.etnEdad.text.toString()
        val edadValor = if (edadTexto.isNotEmpty()) edadTexto.toInt() else 0

        val persona = Persona(nombreTexto, apellidoTexto, edadValor)
        val intent = Intent(this, SegundaActivity::class.java).apply {
            putExtra("persona", persona)
        }

        startActivity(intent)
    }
}
