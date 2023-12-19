package io.redbee.blog.controller;

import io.redbee.blog.models.UsuarioModel;
import io.redbee.blog.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return this.usuarioService.guardarUsuario(usuarioModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUsuarioId(@PathVariable("id") Long id){
        return this.usuarioService.getUsuarioId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        return (this.usuarioService.eliminarUsuario(id)) ? "Usuario eliminado con id: " + id:" Usuario no encontrado con id: " + id;
    }

}
