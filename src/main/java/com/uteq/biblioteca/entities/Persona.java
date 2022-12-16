package com.uteq.biblioteca.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "cedula", length = 13, unique = true, nullable = false)
    private String cedula;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "genero", length = 1, nullable = false)
    private String genero;

    @Column(name = "email", unique = true, length = 50, nullable = false)
    private String email;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;


    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

    public Persona(int idPersona, String nombres, String apellidos, String cedula, String direccion, String genero,
                   String email, String telefono, Date fechaPublicacion, LocalDateTime fechaRegistro) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.genero = genero;
        this.email = email;
        this.telefono = telefono;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaRegistro = fechaRegistro;
    }

    public Persona() {
    }
}
