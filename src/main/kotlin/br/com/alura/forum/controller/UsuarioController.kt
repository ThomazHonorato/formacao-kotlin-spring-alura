package br.com.alura.forum.controller

import br.com.alura.forum.domain.model.Usuario
import br.com.alura.forum.domain.request.UsuarioRequest
import br.com.alura.forum.domain.response.UsuarioResponse
import br.com.alura.forum.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val usuarioService: UsuarioService
) {
    @PostMapping("/cadastrar")
    fun cadastrarUsuario(@RequestBody @Valid usuarioRequest: UsuarioRequest): UsuarioResponse {
        return usuarioService.cadastrarAutor(usuarioRequest.nome, usuarioRequest.email)
    }

    @GetMapping("/all")
    fun buscarUsuarios(): List<UsuarioResponse> {
        return usuarioService.buscarUsuarios();
    }

}