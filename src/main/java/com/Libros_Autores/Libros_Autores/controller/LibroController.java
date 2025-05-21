package com.Libros_Autores.Libros_Autores.Controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.Libros_Autores.Libros_Autores.Model.Autor;
import com.Libros_Autores.Libros_Autores.Model.Libro;
import com.Libros_Autores.Libros_Autores.Service.AutorService;
import com.Libros_Autores.Libros_Autores.Service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getLibros(){ return libroService.listAll(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Libro> getLibroID(@PathVariable("id") Long ID) {
        Optional<Libro> libro = libroService.find(ID);
        //Añado el responseEntity para que no de errores en el postman
        return ResponseEntity.ok(libro).getBody();
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updatelibro(@PathVariable("id") Long id, @RequestBody Libro libro) {

        try {
            Libro updated = libroService.updateLibro(libro, id);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable("id") Long ID){
        libroService.delete(ID);
    }

    //GET de BUSCAR
    @GetMapping("/buscar")
    public List<Libro> buscarLibros
    (@RequestParam(required = false) String titulo,
     @RequestParam(required = false) Integer anioPublicacion,
     @RequestParam(defaultValue = "id") String sortBy,
     @RequestParam(defaultValue = "asc") String orden){

        return libroService.buscarLibos(titulo, anioPublicacion, sortBy, orden);
    }



}
