package br.com.alura.forum.repository

import br.com.alura.forum.domain.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CursoRepository : JpaRepository<Curso, UUID>