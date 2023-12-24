package io.redbee.blog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String texto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    //@JsonIgnore()
    @JsonBackReference
    private Post post;

/*
    public Comentario(){

    }

    public Comentario(Long id, String texto, Post post) {
        this.id = id;
        this.texto = texto;
        this.post = post;
    }

 */

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
