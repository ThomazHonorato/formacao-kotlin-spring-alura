package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.TopicoDto
import br.com.alura.forum.domain.model.Topico
import br.com.alura.forum.domain.request.TopicoRequest
import br.com.alura.forum.domain.response.TopicoResponse
import br.com.alura.forum.service.TopicoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/topico")
class TopicoController(private val topicoService: TopicoService) {


    @PostMapping("/cadastrar")
    fun cadastrarTopico(@RequestBody topicoRequest: TopicoRequest): ResponseEntity<TopicoResponse> {
        val response = topicoService.cadastrarTopico(topicoRequest)
        return  ResponseEntity.status(200).body(response);
    }

    @GetMapping("/all")
    fun listarTopicos(): ResponseEntity<List<TopicoResponse>> {
        return ResponseEntity.status(200).body(topicoService.listarTopicos())
    }

    @GetMapping("/{id}")
    fun listarTopicoPorId(@PathVariable id: UUID): ResponseEntity<TopicoResponse> {
        return ResponseEntity.status(500).body(null);
    }

}