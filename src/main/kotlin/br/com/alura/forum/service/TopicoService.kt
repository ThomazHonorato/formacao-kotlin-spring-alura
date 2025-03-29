package br.com.alura.forum.service

import br.com.alura.forum.domain.mapper.TopicoMapper
import br.com.alura.forum.domain.model.Topico
import br.com.alura.forum.domain.request.TopicoRequest
import br.com.alura.forum.domain.response.TopicoResponse
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class TopicoService(
    private var topicos: MutableList<Topico>,
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
    private val topicoMapper: TopicoMapper,
    private val topicoRepository: TopicoRepository,) {

    fun cadastrarTopico(topicoRequest: TopicoRequest): TopicoResponse {
        val usuario = usuarioService.buscarUsuarioEntityPorId(topicoRequest.autorId)
            ?: throw NoSuchElementException("Usuario ${topicoRequest.autorId} não encontrado")

        val curso = cursoService.buscarCursoEntityPorId(topicoRequest.cursoId)
            ?: throw NoSuchElementException("Curso ${topicoRequest.cursoId} nãoo encontrado")

        val topico = topicoMapper.toTopicoEntity(topicoRequest, curso, usuario)

        val topicoSalvo = topicoRepository.save(topico)

        return topicoMapper.toTopicoResponse(topicoSalvo)
    }

    fun listarTopicos(): List<TopicoResponse> {
        return topicoRepository.findAll().map(
            topicoMapper::toTopicoResponse
        )
    }
}