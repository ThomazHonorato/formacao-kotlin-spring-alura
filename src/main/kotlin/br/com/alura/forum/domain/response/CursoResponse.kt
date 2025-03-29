package br.com.alura.forum.domain.response

import java.util.*

data class CursoResponse (
    val id: UUID? = null,
    val nome: String,
    val categoria: String,
)