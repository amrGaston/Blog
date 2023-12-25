package io.redbee.blog.controller;

import io.redbee.blog.models.Usuario;
import io.redbee.blog.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Iterable<Usuario>> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> getUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.getUsuarioPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        return (this.usuarioService.eliminarUsuario(id)) ? "Usuario eliminado con id: " + id:" Usuario no encontrado con id: " + id;
    }

    @PutMapping(path = "/{id}")
    public String modificarUsuario(@PathVariable("id") Long id,@RequestBody Usuario usuario){
        return (this.usuarioService.modificarUsuario(id,usuario))? "Usuario modificado con id: " + id: "Usuario con id: " + id + " no encontrado";
    }

}