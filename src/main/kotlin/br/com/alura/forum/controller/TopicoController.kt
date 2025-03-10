package br.com.alura.forum.controller

import br.com.alura.forum.domain.dto.TopicoDto
import br.com.alura.forum.domain.model.Topico
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping("/listar")
    fun listarTopicos(): List<Topico> {
        return topicoService.listarTopicos();
    }

    @GetMapping("/listar/{id}")
    fun listarTopicoById(@PathVariable id: Long): Topico {
        return topicoService.listarTopicoById(id)
    }

    @PostMapping
    fun criarTopico(@RequestBody topico: TopicoDto) {
        topicoService.criarTopico(topico)
    }
}