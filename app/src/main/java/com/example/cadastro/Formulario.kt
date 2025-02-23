package com.example.cadastro

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressaEmEmails: Boolean,
    val sexo: String,
    val cidade: String,
    val estado: String
) {
    override fun toString(): String {
        return "Nome: $nome\nTelefone: $telefone\nE-mail: $email\nIngressou em Emails: $ingressaEmEmails\nSexo: $sexo\nCidade: $cidade\nEstado: $estado"
    }
}