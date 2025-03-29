package br.com.alura.forum.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Respostas(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val autor: Usuario,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val topico: Topico,

    val solucao: Boolean,
)
