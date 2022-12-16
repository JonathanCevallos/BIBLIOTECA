package com.uteq.biblioteca.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "bibliotecario")
public class Bibliotecario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bibliotecario")
    private int idBibliotecario;

    @Column(name = "nombre_usuario", length = 15, unique = true, nullable = false)
    private String nombre_usuario;

    @Column(name = "clave", length = 15, nullable = false)
    private String clave;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;


    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    Persona persona;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

    //


    public Bibliotecario(int idBibliotecario, String nombre_usuario, String clave, LocalDateTime fechaRegistro,
                         Persona persona) {
        this.idBibliotecario = idBibliotecario;
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.fechaRegistro = fechaRegistro;
        this.persona = persona;
    }

    public Bibliotecario() {
    }

}
