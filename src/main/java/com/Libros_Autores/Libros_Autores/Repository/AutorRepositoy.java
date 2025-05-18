package com.Libros_Autores.Libros_Autores.Repository;

import com.Libros_Autores.Libros_Autores.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositoy extends JpaRepository<Autor, Long> {}
