package br.com.alura.forum.domain.model

import br.com.alura.forum.domain.enums.StatusTopico
import java.time.LocalDateTime

data class Topico (

    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Respostas> = ArrayList()
    )