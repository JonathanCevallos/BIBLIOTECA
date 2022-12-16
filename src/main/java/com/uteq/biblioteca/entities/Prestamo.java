package com.uteq.biblioteca.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private int idPrestamo;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_devolucion", nullable = false)
    private Date fechaDevolucion;

    @Column(name = "estado_prestamo", nullable = false)
    private boolean estadoPrestamo;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

//    @ManyToOne
//    @JoinColumn(name = "id_persona", nullable = false)
//    Persona persona;

    //    @ManyToOne
//    @JoinColumn(name = "id_libro", nullable = false)
//    Libro libro;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_bibliotecario", nullable = false)
    Bibliotecario bibliotecario;
    @OneToMany
    private List<Libro> libros;

    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

///


    public Prestamo(Date fechaDevolucion, boolean estadoPrestamo, String descripcion, LocalDateTime fechaRegistro,
                    Persona persona, Bibliotecario bibliotecario, List<Libro> libros) {
        this.fechaDevolucion = fechaDevolucion;
        this.estadoPrestamo = estadoPrestamo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.persona = persona;
        this.bibliotecario = bibliotecario;
        this.libros = libros;
    }

    public Prestamo() {
    }
}
