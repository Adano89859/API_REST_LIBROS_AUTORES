package com.Libros_Autores.Libros_Autores.Controller;

import com.Libros_Autores.Libros_Autores.Model.Autor;
import com.Libros_Autores.Libros_Autores.Service.AutorService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> getAutores(){ return autorService.listAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public void getAutorID(@PathVariable Long ID) {
        autorService.find(ID);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }
    

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Long ID){
        autorService.delete(ID);
    }
}
