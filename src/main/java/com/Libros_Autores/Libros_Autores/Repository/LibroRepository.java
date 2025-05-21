package com.Libros_Autores.Libros_Autores.Repository;

import com.Libros_Autores.Libros_Autores.Model.Libro;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //Para encontrar libros en base a su título
    List<Libro> findByTitulo(String titulo, Sort sort);
    //Para encontrar el libro en base al año de publicación
    List<Libro> findByAnioPublicacion(int anioPublicacion, Sort sort);
    //Para encontrar mediante título y año de publicación
    List<Libro> findByTituloAndAnioPublicacion(String titulo, int anioPublicacion, Sort sort);
}
