package es.etg.dam.pmdm.databridge.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm.databridge.data.Persona
import es.etg.dam.pmdm.databridge.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inicializarVistas()
        mostrarDatosPersona()
    }

    private fun inicializarVistas() {
        binding.btnVolver.setOnClickListener(this)
    }

    private fun mostrarDatosPersona() {
        val persona = intent.getParcelableExtra<Persona>("persona")
        persona?.let {
            binding.ettNombre.setText(it.nombre)
            binding.ettApellido.setText(it.apellido)
            binding.etnEdad.setText(it.edad.toString())
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
