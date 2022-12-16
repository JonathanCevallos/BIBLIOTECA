package com.uteq.biblioteca.entities;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private int idAutor;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombres;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

    ////

    public Autor(int idAutor, String nombres, LocalDateTime fechaRegistro) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.fechaRegistro = fechaRegistro;
    }

    public Autor() {
    }
}
