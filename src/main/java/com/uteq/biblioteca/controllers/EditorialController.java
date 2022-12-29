package com.uteq.biblioteca.controllers;



import com.uteq.biblioteca.entities.Editorial;
import com.uteq.biblioteca.entities.Libro;
import com.uteq.biblioteca.services.AutorService;
import com.uteq.biblioteca.services.CategoriaService;
import com.uteq.biblioteca.services.EditorialService;
import com.uteq.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
public class EditorialController {
	
	@Autowired
    private EditorialService editorialService;
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private LibroService libroService;

    @GetMapping("")
    public String all(){
        return "nuevo_editorial_JAO";
    }

    @GetMapping({"/editoriales"})
    public String listarEditoriales(Model model) throws Exception {
        model.addAttribute("editoriales", editorialService.findAll());
        return "views/lista_editorial_JAO";
    }

    @GetMapping({"/libros2"})
    public String listarEditoriales2(Model model) throws Exception {
        model.addAttribute("editoriales2", editorialService.findAll());
        model.addAttribute("categoria2", categoriaService.findAll());
        model.addAttribute("autor2", autorService.findAll());

        Editorial editorial = new Editorial();
        model.addAttribute("editorialTabla", editorial);
        Libro libro = new Libro();
        model.addAttribute("libro",libro);

        return "nuevo_libro_LSB";
    }

    @PostMapping("/libros2")
    public String guardarLibro(@ModelAttribute("libro") Libro libro){
        try {
            libroService.save(libro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }


/*    @GetMapping("editoriale")
    public String findAll(Model model) {
        try {
            List<Editorial> editoriales = this.editorialService.findAll();
            model.addAttribute("editoriales", editoriales);
            return "views/editoriales_JAO";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }*/

    //LISTAR TODO
//    @GetMapping
//    public ResponseEntity<List<Editorial>> getAll()
//    {
//        try
//        {
//            return ResponseEntity.ok().body(editorialService.findAll());
//        }
//        catch (Exception e)
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }

    //BUSCAR POR ID
/*    @RequestMapping(value = "{id}")
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
    }*/

    //GUARDAR
/*    @PostMapping
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
    }*/

    @GetMapping("editoriales/new")
    public String registrarEditorial(Model model){
        Editorial editorial = new Editorial();
        model.addAttribute("editorial",editorial);
        return "views/nuevo_editorial_JAO";
    }

    @PostMapping("/editoriales")
    public String guardarEditorial(@ModelAttribute("editorial") Editorial editorial){
        try {
            editorialService.save(editorial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/libros/new";
    }


    //ELIMINAR
/*    @DeleteMapping(value =  "{id}")
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
    }*/

}
