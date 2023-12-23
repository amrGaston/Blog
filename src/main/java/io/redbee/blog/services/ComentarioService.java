package io.redbee.blog.services;

import io.redbee.blog.models.Comentario;
import io.redbee.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public ArrayList<Comentario> getComentarios(){
        return (ArrayList<Comentario>) this.comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentarioPorId(Long id){
        return this.comentarioRepository.findById(id);
    }

    public Comentario guardarComentario(Comentario comentario){
        return this.comentarioRepository.save(comentario);
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
