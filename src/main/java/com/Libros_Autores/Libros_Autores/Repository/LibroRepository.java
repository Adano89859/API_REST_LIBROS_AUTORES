package com.Libros_Autores.Libros_Autores.Repository;

import com.Libros_Autores.Libros_Autores.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {}
