package br.com.alura.forum.service

import br.com.alura.forum.domain.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService (var cursos: List<Curso>) {

    /*init{
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Backend",
        );
        val curso2 = Curso(
            id = 2,
            nome = "Java",
            categoria = "Backend",
        );
        val curso3 = Curso(
            id = 3,
            nome = "Python",
            categoria = "Backend",
        )
        cursos = Arrays.asList(curso, curso2, curso3)
    }

    fun buscarCurosoPorId(id: Long) : Curso{
        return cursos.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }*/

}
