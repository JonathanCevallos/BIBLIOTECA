package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Libro;
import com.uteq.biblioteca.services.AutorService;
import com.uteq.biblioteca.services.CategoriaService;
import com.uteq.biblioteca.services.EditorialService;
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
    @Autowired
    EditorialService editorialService;
    @Autowired
    CategoriaService categoriaService;

    @Autowired
    AutorService autorService;


    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<Libro> libros = this.libroService.findAll();
            model.addAttribute("libros", libros);
            return "views/libros_JAO";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarLibro(@ModelAttribute("libro") Libro libro){
        try {
            libroService.save(libro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newLibro(Model model) throws Exception {
        model.addAttribute("editoriales", editorialService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("autores", autorService.findAll());
        Libro libro = new Libro();
        model.addAttribute("libro",libro);
        return "views/nuevo_libro_LSB";
    }

    @GetMapping(value = "/all")
    public String libros() {
        return "views/libros";
    }

    @GetMapping(value = "/nuevo")
    public String save(Model model) {
        Libro libro = new Libro();
        model.addAttribute("libro", libro);
        return "views/nuevo_libro_LSB";
    }


}
