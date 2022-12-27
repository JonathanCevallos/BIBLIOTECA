package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Editorial;
import com.uteq.biblioteca.entities.Libro;
import com.uteq.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("libros")
@CrossOrigin("*")
public class LibroController {

    @Autowired
    private LibroService libroService;


    @GetMapping("")
    public String all(){
        return "views/libros_LSB";
    }
    //LISTAR TODO

    @GetMapping("libos")
    public String findAll(Model model) {
        try {
            List<Libro> libros = this.libroService.findAll();
            model.addAttribute("libros", libros);
            return "views/libros";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @GetMapping(value = "/all")
    public String libros() {
        return "views/libros";
    }

    @GetMapping(value = "/nuevo")
    public String save(Model model) {
        Libro libro = new Libro();
        model.addAttribute("libro", libro);
        return "views/nuevo_libro";
    }


}
