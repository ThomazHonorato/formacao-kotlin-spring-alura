package br.com.alura.forum.domain.request

import java.time.LocalDateTime
import java.util.*

class TopicoRequest(
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    val cursoId: UUID,
    val autorId: UUID

)