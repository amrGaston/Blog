package io.redbee.blog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String nombre;
    private String correo;
    @OneToMany(mappedBy = "usuario",  cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posteos = new ArrayList<>();

    /*
    public Usuario(){

    }

    public Usuario(Long id, String nombre, String correo, ArrayList<Post> posteos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.posteos = posteos;
    }

     */

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Post> getPosteos() {
        return posteos;
    }

    public void setPosteos(List<Post> posteos) {
        this.posteos = posteos;
        for (Post post: posteos){
            post.setUsuario(this);
        }
    }
}