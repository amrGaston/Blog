package io.redbee.blog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comentario> comentarios = new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    private Float compra;
    private Float venta;
    private Date date = new Date();

    /*
    public Post(){
    }

    public Post(Long id, Float compra, Float venta, List<Comentario> comentarios) {
        this.id = id;
        this.compra = compra;
        this.venta = venta;
        this.comentarios = comentarios;
    }

     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCompra() {
        return compra;
    }

    public Float getVenta() {
        return venta;
    }

    public Date getDate() {
        return date;
    }

    public void setCompra(Float compra) {
        this.compra = compra;
    }

    public void setVenta(Float venta) {
        this.venta = venta;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
        for (Comentario comentario : comentarios){
            comentario.setPost(this);
        }
    }

    public void agregarComentario(Comentario comentario){
        this.comentarios.add(comentario);
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }
}
