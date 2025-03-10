package br.com.alura.forum.service

import br.com.alura.forum.domain.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Thomaz",
            email = "thomaz@gmail.com",
        );
        val usuario2 = Usuario(
            id = 2,
            nome = "Jefferson",
            email = "Jefferson@gmail.com",
        );
        val usuario3 = Usuario(
            id = 3,
            nome = "Laura",
            email = "Laura@gmail.com",
        );

        usuarios = Arrays.asList(usuario, usuario2, usuario3)
    }

    fun buscarUsuarioPorId(id: Long): Usuario {
        return usuarios.stream().filter({
            u -> u.id == id
        }).findFirst().get()
    }
}