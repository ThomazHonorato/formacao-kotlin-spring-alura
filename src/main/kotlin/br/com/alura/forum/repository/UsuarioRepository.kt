package br.com.alura.forum.repository

import br.com.alura.forum.domain.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Repository
interface UsuarioRepository : JpaRepository<Usuario, UUID>
