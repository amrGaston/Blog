package io.redbee.blog.services;

import io.redbee.blog.models.Usuario;
import io.redbee.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Iterable<Usuario>> getUsuarios(){
        return Arrays.asList(usuarioRepository.findAll());
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public boolean eliminarUsuario(Long id) {
        Boolean encontrado = usuarioRepository.findById(id).isPresent();
        if (encontrado) {
            usuarioRepository.deleteById(id);
        }
        return encontrado;

    }

    public Optional<Usuario> getUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public boolean modificarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioActual = usuarioRepository.findById(id);
        boolean actualizado = false;
        if (usuarioActual.isPresent()){
            Usuario usuarioAGuardar = usuarioActual.get();
            usuarioAGuardar.setNombre(usuario.getNombre());
            usuarioAGuardar.setCorreo(usuario.getCorreo());
            usuarioAGuardar.setPosteos(usuario.getPosteos());
            usuarioRepository.save(usuarioAGuardar);
            actualizado = true;
        }
        return actualizado;
    }
}