package br.com.alura.forum.controller

import br.com.alura.forum.domain.model.Usuario
import br.com.alura.forum.domain.request.UsuarioRequest
import br.com.alura.forum.domain.response.UsuarioResponse
import br.com.alura.forum.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val usuarioService: UsuarioService
) {
    @PostMapping("/cadastrar")
    fun cadastrarUsuario(@RequestBody @Valid usuarioRequest: UsuarioRequest): ResponseEntity<UsuarioResponse> {
        val response = usuarioService.cadastrarAutor(usuarioRequest)
        return ResponseEntity.status(200).body(response)
    }

    @GetMapping("/all")
    fun buscarUsuarios(): ResponseEntity<List<UsuarioResponse>> {
        val usuarios = usuarioService.buscarUsuarios()
        return ResponseEntity.status(200).body(usuarios)
    }

    @GetMapping("/{id}")
    fun buscarUsuarios(@PathVariable id: UUID): ResponseEntity<UsuarioResponse> {
        val usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.status(200).body(usuario)
    }

}