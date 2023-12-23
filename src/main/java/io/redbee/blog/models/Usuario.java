package io.redbee.blog.models;

import jakarta.persistence.*;

import java.util.ArrayList;
/*
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String nombre;
    private String correo;
    @OneToMany(mappedBy = "usuario")
    private ArrayList<Post> posteos;

    public Usuario(){

    }

    public Usuario(Long id, String nombre, String correo, ArrayList<Post> posteos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.posteos = posteos;
    }

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

    public ArrayList<Post> getPosteos() {
        return posteos;
    }

    public void setPosteos(ArrayList<Post> posteos) {
        this.posteos = posteos;
    }
}


 */