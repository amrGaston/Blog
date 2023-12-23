package io.redbee.blog.services;
/*
import io.redbee.blog.models.Post;
import io.redbee.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ArrayList<Post> getPost(){
        return (ArrayList<Post>) postRepository.findAll();
    }

    public Post guardarPost(Post post){
        return postRepository.save(post);
    }

    public boolean eliminarPost(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }

    }

    public Optional<Post> getPostPorId(Long id) {
        return postRepository.findById(id);
    }

}
*/