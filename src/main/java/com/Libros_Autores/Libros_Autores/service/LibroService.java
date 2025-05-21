package com.Libros_Autores.Libros_Autores.Service;

import com.Libros_Autores.Libros_Autores.Model.Libro;
import com.Libros_Autores.Libros_Autores.Repository.LibroRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

        private final LibroRepository libroRepository;

        public LibroService(LibroRepository libroRepository){
            this.libroRepository = libroRepository;
        }

        public List<Libro> listAll() {return libroRepository.findAll(); }
        public Libro save(Libro libro) {return libroRepository.save(libro); }
        public Optional<Libro> find(Long ID) {return libroRepository.findById(ID); }
        public void delete(Long ID) {libroRepository.deleteById(ID);}

        public Libro updateLibro(Libro updatedlibro, Long id) {
                // Verificar si el usuario existe en la base de datos
                Optional<Libro> optionalLibro = libroRepository.findById(id);

                // Obtener el libro existente
                Libro existingLibro = optionalLibro.get();

                // Aplicar las actualizaciones en el libro existente
                existingLibro.setTitulo(updatedlibro.getTitulo());
                existingLibro.setIsbn(updatedlibro.getIsbn());
                existingLibro.setAnioPublicacion(updatedlibro.getAnioPublicacion());
                existingLibro.setAutor(updatedlibro.getAutor());

                // Guardar los cambios en la base de datos
                return libroRepository.save(existingLibro);
        }

        //Método que será usado en "Buscar"
        public List<Libro> buscarLibos(String titulo, Integer anioPublicacion, String sortBy, String orden){

                //Creo la variable sort que servirá para el orden
                Sort mostrarOrden;

                //Uso el String "orden" para saber de qué manera los voy a ordenar; el "IgnoreCase" es para que no me de error si es null
                if(orden.equalsIgnoreCase("desc")){
                        //Ordeno de forma descendente
                        mostrarOrden = Sort.by(sortBy).descending();
                }else{
                        //Ordeno de forma ascendente
                        mostrarOrden = Sort.by(sortBy).ascending();
                }

                //Filtro según los parametros de busqueda mete el usuario
                if(titulo != null && anioPublicacion != null){
                        return libroRepository.findByTituloAndAnioPublicacion(titulo, anioPublicacion, mostrarOrden);
                } else if(titulo != null){
                        return libroRepository.findByTitulo(titulo,mostrarOrden);
                } else if(anioPublicacion != null){
                        return libroRepository.findByAnioPublicacion(anioPublicacion,mostrarOrden);
                }else{
                        return libroRepository.findAll(mostrarOrden);
                }

        }

}


