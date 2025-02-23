package com.example.cadastro

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val formulario = salvarFormulario()

            exibirToasts(formulario)
        }

        binding.button4.setOnClickListener {
            limparFormulario()
        }
    }

    private fun salvarFormulario(): Formulario {
        val nome = binding.etNome.text.toString()
        val telefone = binding.etTelefone.text.toString()
        val email = binding.etEmail.text.toString()
        val recebeEmails = binding.cbReceberEmail.isChecked
        val cidade = binding.etCidade.text.toString()
        val estado = binding.spEstado.selectedItem.toString()

        val selectedId = binding.rgSexo.checkedRadioButtonId
        val sexo = if (selectedId != -1) {
            findViewById<RadioButton>(selectedId).text.toString()
        } else {
            "Não informado"
        }

        return Formulario(nome, telefone, email, recebeEmails, sexo, cidade, estado)
    }

    private fun exibirToasts(formulario: Formulario) {
        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
    }


    private fun limparFormulario() {
        binding.etNome.text.clear()
        binding.etTelefone.text.clear()
        binding.etEmail.text.clear()
        binding.cbReceberEmail.isChecked = false
        binding.rgSexo.clearCheck()
        binding.etCidade.text.clear()
        binding.spEstado.setSelection(0)
    }
}