package br.com.alura.forum.domain.mapper

import br.com.alura.forum.domain.model.Curso
import br.com.alura.forum.domain.model.Topico
import br.com.alura.forum.domain.model.Usuario
import br.com.alura.forum.domain.request.TopicoRequest
import br.com.alura.forum.domain.response.TopicoResponse
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TopicoMapper {

    fun toTopicoEntity(topicoRequest: TopicoRequest, curso: Curso, autor: Usuario): Topico {
        return Topico(
            titulo = topicoRequest.titulo,
            mensagem = topicoRequest.mensagem,
            dataCriacao = topicoRequest.dataCriacao,
            curso = curso,
            autor = autor,
        )
    }

    fun toTopicoResponse(topico:Topico): TopicoResponse {
        return TopicoResponse(
            id = topico.id!!,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            nomeCurso = topico.curso.nome,
            nomeAutor = topico.autor.nome,
            status = topico.status.name
        )
    }

}