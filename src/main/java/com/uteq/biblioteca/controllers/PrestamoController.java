package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Prestamo;
import com.uteq.biblioteca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prestamos")
@CrossOrigin("*")
public class PrestamoController {
	
	@Autowired
    private PrestamoService prestamoService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Prestamo>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(prestamoService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Prestamo> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(prestamoService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Prestamo> create (@RequestBody Prestamo entity)
    {
        try
        {
            return ResponseEntity.ok().body(prestamoService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(prestamoService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Prestamo>update(@PathVariable int id, @RequestBody Prestamo entity)
    {
        try
        {
            return ResponseEntity.ok().body(prestamoService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
