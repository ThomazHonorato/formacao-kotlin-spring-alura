package br.com.alura.forum.domain.model

import br.com.alura.forum.domain.enums.StatusTopico
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@Entity
data class Topico (

    @Id
    @GeneratedValue
    val id: UUID? = null,

    val titulo: String = "",
    val mensagem: String = "",
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(cascade = [CascadeType.ALL])
    val curso: Curso,

    @ManyToOne(cascade = [CascadeType.ALL])
    val autor: Usuario,

    @Enumerated(EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val respostas: List<Respostas> = ArrayList()
    )