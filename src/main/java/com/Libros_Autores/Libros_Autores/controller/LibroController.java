package com.Libros_Autores.Libros_Autores.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.Libros_Autores.Libros_Autores.Model.Autor;
import com.Libros_Autores.Libros_Autores.Model.Libro;
import com.Libros_Autores.Libros_Autores.Service.AutorService;
import com.Libros_Autores.Libros_Autores.Service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/autores")

public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getLibros(){ return libroService.listAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public void getLibroID(@PathVariable Long ID) {
        libroService.find(ID);
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updatelibro(@PathVariable Long id, @RequestBody Libro libro) {

        try {
            Libro updated = libroService.updateLibro(libro, id);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long ID){
        libroService.delete(ID);
    }

    //GET de BUSCAR
    @GetMapping("/buscar")
    public List<Libro> buscarLibros
    (@RequestParam(required = false) String titulo,
     @RequestParam(required = false) int anioPublicacion,
     @RequestParam(required = false) String sortBy,
     @RequestParam(required = false) String orden){

        return libroService.buscarLibos(titulo, anioPublicacion, sortBy, orden);
    }



}
