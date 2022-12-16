package com.uteq.biblioteca.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }


    public Categoria(int idCategoria, String nombre, LocalDateTime fechaRegistro) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria() {
    }
}
