package com.Libros_Autores.Libros_Autores.Service;

import com.Libros_Autores.Libros_Autores.Model.Libro;
import com.Libros_Autores.Libros_Autores.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

        private final LibroRepository libroRepository;

        public LibroService(LibroRepository libroRepository){
            this.libroRepository = libroRepository;
        }

        public List<Libro> listAll() {return libroRepository.findAll(); }
        public Libro save(Libro libro) {return libroRepository.save(libro); }
        public void find(Long ID) {libroRepository.findById(ID); }
        public void delete(Long ID) {libroRepository.deleteById(ID);}

}


