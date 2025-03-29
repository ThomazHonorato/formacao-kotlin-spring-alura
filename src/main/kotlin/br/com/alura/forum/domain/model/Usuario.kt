package br.com.alura.forum.domain.model

import jakarta.persistence.*
import java.util.UUID

@Entity
data class Usuario (

    @Id
    @GeneratedValue
    val id: UUID? = null,

    val nome: String = "",
    val email: String = "",
)
