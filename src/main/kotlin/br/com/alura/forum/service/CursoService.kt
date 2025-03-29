package br.com.alura.forum.service

import br.com.alura.forum.domain.mapper.CursoMapper
import br.com.alura.forum.domain.request.CursoRequest
import br.com.alura.forum.domain.response.CursoResponse
import br.com.alura.forum.domain.response.UsuarioResponse
import br.com.alura.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(
    private val cursoRepository: CursoRepository,
    private val cursoMapper: CursoMapper,
) {

    fun cadastrarCurso(cursoRequest: CursoRequest): CursoResponse {
        val curso = cursoMapper.toCursoEntity(cursoRequest)
        val cursoSalvo = cursoRepository.save(curso)
        return cursoMapper.toCursoResponse(cursoSalvo)
    }

    fun buscarCursos():List<CursoResponse>{
        return cursoRepository.findAll().map{cursoMapper.toCursoResponse(it)}
    }

    fun buscarCursoPorId(id: UUID): CursoResponse {
        val curso = cursoRepository.findById(id)
            .orElseThrow { NoSuchElementException("Curso com id $id não encontrado") }

        return cursoMapper.toCursoResponse(curso);
    }

}
