package io.redbee.blog.services;

import io.redbee.blog.models.Comentario;
import io.redbee.blog.models.Post;
import io.redbee.blog.models.Usuario;
import io.redbee.blog.repository.PostRepository;
import io.redbee.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Iterable<Post>> getPost(){
        return Arrays.asList(postRepository.findAll());
    }

    public Post guardarPost(Post post){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(post.getUsuario().getId());
        Post postGuardado = null;
        if (usuarioOptional.isPresent()){
            post.setUsuario(usuarioOptional.get());
            postGuardado = this.postRepository.save(post);
        }
        return postGuardado;
    }

    public boolean eliminarPost(Long id) {
        Boolean encontrado = postRepository.findById(id).isPresent();
        if (encontrado) {
            postRepository.deleteById(id);
        }
        return encontrado;
    }

    public Optional<Post> getPostPorId(Long id) {
        return postRepository.findById(id);
    }

    public boolean modificarPost(Long id, Post post) {
       Optional<Post> postActual = postRepository.findById(id);
       Boolean actualizado = false;
       if (postActual.isPresent()){
           Post postAGuardar = postActual.get();
           postAGuardar.setCompra(post.getCompra());
           postAGuardar.setVenta(post.getVenta());
           postAGuardar.setDate(post.getDate());
           postAGuardar.setComentarios(post.getComentarios());
           postRepository.save(postAGuardar);
           actualizado = true;
       }
       return actualizado;
    }


    public boolean agregarComentario(Long id, Comentario comentario) {
        Optional<Post> postActual = postRepository.findById(id);
        Boolean actualizado = false;
        if (postActual.isPresent()){
            Post postAGuardar = postActual.get();
            comentario.setPost(postAGuardar);
            postAGuardar.agregarComentario(comentario);
            postRepository.save(postAGuardar);
            actualizado = true;
        }
        return actualizado;
    }
}
