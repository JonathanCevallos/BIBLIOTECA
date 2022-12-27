package com.uteq.biblioteca.controllers;


import com.uteq.biblioteca.entities.Categoria;
import com.uteq.biblioteca.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;


/*    @GetMapping({"/libros2"})
    public String listarEditoriales2(Model model) throws Exception {
        model.addAttribute("categoria2", categoriaService.findAll());
        return "/views/libros_LSB";
    }*/

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Categoria> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Categoria> create (@RequestBody Categoria entity)
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoriaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Categoria>update(@PathVariable int id, @RequestBody Categoria entity)
    {
        try
        {
            return ResponseEntity.ok().body(categoriaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

}
