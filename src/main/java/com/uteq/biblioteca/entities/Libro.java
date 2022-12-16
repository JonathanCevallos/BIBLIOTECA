package com.uteq.biblioteca.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "ruta_portada", length = 100)
    private String rutaPortad;

    @Column(name = "ubicacion", nullable = false, length = 20)
    private String ubicacion;

    @Column(name = "ejemplares")
    private int ejemplares;

    @Column(name = "isbn", length = 17)
    private String isbn;

    @Column(name = "doi", length = 50)
    private String doi;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    Editorial editorial;

    @OneToMany
    private List<Categoria> categorias;

    @OneToMany
    private List<Autor> autores;


    @PrePersist
    public void PrePersist() {
        fechaRegistro = LocalDateTime.now();
    }

    public Libro(String titulo, String rutaPortad, String ubicacion, int ejemplares, String isbn, String doi,
                 LocalDateTime fechaRegistro, Editorial editorial, List<Categoria> categorias, List<Autor> autores) {
        this.titulo = titulo;
        this.rutaPortad = rutaPortad;
        this.ubicacion = ubicacion;
        this.ejemplares = ejemplares;
        this.isbn = isbn;
        this.doi = doi;
        this.fechaRegistro = fechaRegistro;
        this.editorial = editorial;
        this.categorias = categorias;
        this.autores = autores;
    }

    public Libro() {
    }
}
