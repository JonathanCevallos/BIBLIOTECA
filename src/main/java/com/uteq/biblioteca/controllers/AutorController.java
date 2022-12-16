package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Autor;
import com.uteq.biblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autor")
@CrossOrigin("*")
public class AutorController {
	
	@Autowired
    private AutorService autorService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Autor>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(autorService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Autor> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(autorService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Autor> create (@RequestBody Autor entity)
    {
        try
        {
            return ResponseEntity.ok().body(autorService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Autor>update(@PathVariable int id, @RequestBody Autor entity)
    {
        try
        {
            return ResponseEntity.ok().body(autorService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
