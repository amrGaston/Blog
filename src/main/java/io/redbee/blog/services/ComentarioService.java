package io.redbee.blog.services;

import io.redbee.blog.models.Comentario;
import io.redbee.blog.models.Post;
import io.redbee.blog.repository.ComentarioRepository;
import io.redbee.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Iterable<Comentario>> getComentarios(){
        return Arrays.asList(this.comentarioRepository.findAll());
    }

    public Optional<Comentario> getComentarioPorId(Long id){
        return this.comentarioRepository.findById(id);
    }

    public Comentario guardarComentario(Comentario comentario){
        Optional<Post> postOptional = postRepository.findById(comentario.getPost().getId());

        Comentario comentarioGuardado = null;
        if (postOptional.isPresent()){
            comentario.setPost(postOptional.get());
            comentarioGuardado = this.comentarioRepository.save(comentario);
        }

        return comentarioGuardado;
    }

    public Boolean deleteComentario(Long id){
        Boolean encontrado = comentarioRepository.findById(id).isPresent();
        if (encontrado) {
            comentarioRepository.deleteById(id);
        }
        return encontrado;
    }

    public Boolean modificarComentario(Long id, Comentario comentario) {
        Optional<Comentario> comentarioActual = comentarioRepository.findById(id);
        Boolean actualizado = false;
        if (comentarioActual.isPresent()){
            Comentario comentarioAguardar = comentarioActual.get();
            comentarioAguardar.setTexto(comentario.getTexto());
            comentarioRepository.save(comentarioAguardar);
            actualizado = true;
        }
        return actualizado;
    }
}
