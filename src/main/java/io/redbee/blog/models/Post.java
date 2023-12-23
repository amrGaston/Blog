package io.redbee.blog.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
/*
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    //@OneToMany(mappedBy = "post")
    //private ArrayList<Comentario> comentarios;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Float compra;
    private Float venta;
    private Date date;

    public Post(){

    }

    public Post(Long id, ArrayList<Comentario> comentarios, Float compra, Float venta, Date date) {
        this.id = id;
        //this.comentarios = comentarios;
        this.compra = compra;
        this.venta = venta;
        this.date = date;
    }

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

    /*
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }



}

*/