package br.com.alura.forum.repository

import br.com.alura.forum.domain.model.Topico
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TopicoRepository : JpaRepository<Topico, UUID>