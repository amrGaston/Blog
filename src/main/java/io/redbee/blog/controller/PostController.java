package io.redbee.blog.controller;


import io.redbee.blog.models.Post;
import io.redbee.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public List<Iterable<Post>> getPost(){
        return this.postService.getPost();
    }

    @PostMapping
    public Post guardarPost(@RequestBody Post post){
        return this.postService.guardarPost(post);
    }

    @GetMapping(path = "/{id}")
    public Optional<Post> getPostPorId(@PathVariable("id") Long id){
        return this.postService.getPostPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPost(@PathVariable("id") Long id){
        return (this.postService.eliminarPost(id)) ? "Post eliminado con id: " + id:" Post no encontrado con id: " + id;
    }

    @PutMapping(path = "/{id}")
    public String modificarPost(@PathVariable("id") Long id,@RequestBody Post post){
        return (this.postService.modificarPost(id,post))? "Post modificado con id: " + id: "Post con id: " + id + " no encontrado";
    }

}