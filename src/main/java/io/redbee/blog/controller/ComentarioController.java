package io.redbee.blog.controller;

import io.redbee.blog.models.Comentario;
import io.redbee.blog.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ArrayList<Comentario> getComentarios(){
        return this.comentarioService.getComentarios();
    }

    @PostMapping
    public Comentario guardarComentario(@RequestBody Comentario comentario){
        return this.comentarioService.guardarComentario(comentario);
    }

    @GetMapping(path = "/{id}")
    public Optional<Comentario> getComentarioPorId(@PathVariable("id") Long id){
        return this.comentarioService.getComentarioPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteComentario(@PathVariable("id") Long id){
        return (this.comentarioService.deleteComentario(id))? "Comentario eliminado con id: " + id: "Comentario con id: " + id + " no encontrado";
    }

    @PutMapping(path = "/{id}")
    public String modificarComentario(@PathVariable("id") Long id,@RequestBody Comentario comentario){
        return (this.comentarioService.modificarComentario(id,comentario))? "Comentario modificado con id: " + id: "Comentario con id: " + id + " no encontrado";
    }





}
