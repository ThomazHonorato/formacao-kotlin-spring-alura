package br.com.alura.forum.domain.mapper

import br.com.alura.forum.domain.model.Curso
import br.com.alura.forum.domain.model.Usuario
import br.com.alura.forum.domain.request.UsuarioRequest
import br.com.alura.forum.domain.response.UsuarioResponse
import org.springframework.stereotype.Component

@Component
class UsuarioMapper {

    fun toUsuarioEntity(usuarioRequest: UsuarioRequest): Usuario {
        return Usuario(
            nome = usuarioRequest.nome,
            email = usuarioRequest.email,
        )
    }

    fun toUsuarioResponse(usuario: Usuario): UsuarioResponse {
        return UsuarioResponse(
            id = usuario.id!!,
            nome = usuario.nome,
            email = usuario.email,
        )
    }
}