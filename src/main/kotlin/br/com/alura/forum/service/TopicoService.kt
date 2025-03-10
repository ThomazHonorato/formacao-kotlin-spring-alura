package br.com.alura.forum.service

import br.com.alura.forum.domain.dto.TopicoDto
import br.com.alura.forum.domain.model.Curso
import br.com.alura.forum.domain.model.Topico
import br.com.alura.forum.domain.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(
    private var topicos: List<Topico>,
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvidas Kotlin 1",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Backend",
            ),
            autor = Usuario(
                id = 1,
                nome = "Thomaz",
                email = "thomaz@gmail.com",
            ),
        );
        val topico2 = Topico(
            id = 2,
            titulo = "Duvidas Kotlin 2",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Backend",
            ),
            autor = Usuario(
                id = 1,
                nome = "Thomaz",
                email = "thomaz@gmail.com",
            ),
        );
        val topico3 = Topico(
            id = 3,
            titulo = "Duvidas Kotlin 3",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Backend",
            ),
            autor = Usuario(
                id = 1,
                nome = "Thomaz",
                email = "thomaz@gmail.com",
            ),
        )
        topicos = listOf(topico, topico2, topico3)
    }

    fun listarTopicos(): List<Topico> {
        return topicos
    }

    fun listarTopicoById(id: Long): Topico {
        return topicos.stream().filter({ t ->
            t.id == id
        }).findFirst().get()
    }

    fun criarTopico(topico: TopicoDto) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong()+1,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            curso = cursoService.buscarCurosoPorId(topico.idCurso),
            autor = usuarioService.buscarUsuarioPorId(topico.idAutor),
        ))
    }

}