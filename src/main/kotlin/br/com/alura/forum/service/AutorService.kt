package br.com.alura.forum.service

import br.com.alura.forum.domain.model.Usuario
import br.com.alura.forum.domain.response.UsuarioResponse
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    var usuarios: List<Usuario>,
    private val usuarioRepository: UsuarioRepository
) {

    fun cadastrarAutor(nome: String, email: String): UsuarioResponse {
        return with(usuarioRepository.save(Usuario(nome = nome, email = email))) {
            UsuarioResponse(id = id!!, nome = nome, email = email)
        }
    }

    fun buscarUsuarios(): List<UsuarioResponse> {
        return usuarioRepository.findAll().map {
            UsuarioResponse(
                id = it.id!!,
                nome = it.nome,
                email = it.email
            )
        }
    }

    /*fun buscarUsuarioPorId(id: Long): Usuario {
        return usuarios.stream().filter({
            u -> u.id == id
        }).findFirst().get()
    }*/
}