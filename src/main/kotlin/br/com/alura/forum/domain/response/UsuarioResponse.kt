package br.com.alura.forum.domain.response

import java.time.LocalDateTime
import java.util.*

data class UsuarioResponse(
    val id: UUID? = null,
    val nome: String,
    val email: String,
)
