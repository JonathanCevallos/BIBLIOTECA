package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Libro;
import com.uteq.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
@CrossOrigin("*")
public class LibroController {
	
	@Autowired
    private LibroService libroService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Libro>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(libroService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Libro> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(libroService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Libro> create (@RequestBody Libro entity)
    {
        try
        {
            return ResponseEntity.ok().body(libroService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(libroService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Libro>update(@PathVariable int id, @RequestBody Libro entity)
    {
        try
        {
            return ResponseEntity.ok().body(libroService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
