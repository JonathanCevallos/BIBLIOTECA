package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Bibliotecario;
import com.uteq.biblioteca.services.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bibliotecarios")
@CrossOrigin("*")
public class BibliotecarioController {
	
	@Autowired
    private BibliotecarioService bibliotecarioService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Bibliotecario>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(bibliotecarioService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Bibliotecario> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(bibliotecarioService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Bibliotecario> create (@RequestBody Bibliotecario entity)
    {
        try
        {
            return ResponseEntity.ok().body(bibliotecarioService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bibliotecarioService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Bibliotecario>update(@PathVariable int id, @RequestBody Bibliotecario entity)
    {
        try
        {
            return ResponseEntity.ok().body(bibliotecarioService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
