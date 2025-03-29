package br.com.alura.forum.service

import br.com.alura.forum.domain.mapper.UsuarioMapper
import br.com.alura.forum.domain.request.UsuarioRequest
import br.com.alura.forum.domain.response.UsuarioResponse
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val usuarioMapper: UsuarioMapper
) {

    fun cadastrarAutor(usuarioRequest: UsuarioRequest): UsuarioResponse {
        val usuario = usuarioMapper.toUsuarioEntity(usuarioRequest)
        val usuarioSalvo = usuarioRepository.save(usuario)
        return usuarioMapper.toUsuarioResponse(usuarioSalvo)
    }

    fun buscarUsuarios(): List<UsuarioResponse> {
        return usuarioRepository.findAll().map {
            usuarioMapper.toUsuarioResponse(it)
        }
    }

    fun buscarUsuarioPorId(id: UUID): UsuarioResponse {
        val usuario = usuarioRepository.findById(id)
            .orElseThrow { NoSuchElementException("Usuário com id $id não encontrado") }

        return usuarioMapper.toUsuarioResponse(usuario)
    }
}