package br.com.alura.forum.controller

import br.com.alura.forum.domain.request.CursoRequest
import br.com.alura.forum.domain.response.CursoResponse
import br.com.alura.forum.domain.response.UsuarioResponse
import br.com.alura.forum.service.CursoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/curso")
class CursoController (
    private val cursoService: CursoService
){
    @PostMapping("/cadastrar")
    fun cadastrarCurso(@RequestBody cursoRequest: CursoRequest): ResponseEntity<CursoResponse> {
        val response = cursoService.cadastrarCurso(cursoRequest)
        return ResponseEntity.status(200).body(response)
    }

    @GetMapping("/all")
    fun buscarCursos():ResponseEntity<List<CursoResponse>>{
        val response = cursoService.buscarCursos()
        return ResponseEntity.status(200).body(response)
    }

    @GetMapping("/{id}")
    fun buscarCursoPorId(@PathVariable id: UUID): ResponseEntity<CursoResponse> {
        val response = cursoService.buscarCursoPorId(id)
        return ResponseEntity.status(200).body(response)
    }
}