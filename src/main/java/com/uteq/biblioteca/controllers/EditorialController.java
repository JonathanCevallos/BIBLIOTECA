package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Editorial;
import com.uteq.biblioteca.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/editoiales")
@CrossOrigin("*")
public class EditorialController {
	
	@Autowired
    private EditorialService editorialService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Editorial>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(editorialService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Editorial> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(editorialService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Editorial> create (@RequestBody Editorial entity)
    {
        try
        {
            return ResponseEntity.ok().body(editorialService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(editorialService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Editorial>update(@PathVariable int id, @RequestBody Editorial entity)
    {
        try
        {
            return ResponseEntity.ok().body(editorialService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
