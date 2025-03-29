package br.com.alura.forum.domain.mapper

import br.com.alura.forum.domain.model.Curso
import br.com.alura.forum.domain.request.CursoRequest
import br.com.alura.forum.domain.response.CursoResponse
import org.springframework.stereotype.Component

@Component
class CursoMapper {

    fun toCursoEntity(cursoRequest: CursoRequest): Curso {
        return Curso(
            nome = cursoRequest.nome,
            categoria = cursoRequest.categoria,
        )
    }

    fun toCursoResponse(curso: Curso): CursoResponse {
        return CursoResponse(
            id = curso.id!!,
            nome = curso.nome,
            categoria = curso.categoria,
        )
    }
}