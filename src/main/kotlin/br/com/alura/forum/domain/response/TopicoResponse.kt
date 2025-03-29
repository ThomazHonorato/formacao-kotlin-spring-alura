package br.com.alura.forum.domain.response

import java.time.LocalDateTime
import java.util.UUID

class TopicoResponse (
    val id: UUID,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime,

    val nomeCurso: String,
    val nomeAutor: String,

    val status: String,
)