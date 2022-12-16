package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Persona;
import com.uteq.biblioteca.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personas")
@CrossOrigin("*")
public class PersonaController {
	
	@Autowired
    private PersonaService personaService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Persona>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(personaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Persona> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(personaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Persona> create (@RequestBody Persona entity)
    {
        try
        {
            return ResponseEntity.ok().body(personaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Persona>update(@PathVariable int id, @RequestBody Persona entity)
    {
        try
        {
            return ResponseEntity.ok().body(personaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
