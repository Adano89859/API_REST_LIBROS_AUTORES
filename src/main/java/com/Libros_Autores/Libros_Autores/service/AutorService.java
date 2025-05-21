package com.Libros_Autores.Libros_Autores.Service;

import com.Libros_Autores.Libros_Autores.Model.Autor;
import com.Libros_Autores.Libros_Autores.Repository.AutorRepositoy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {

   private final AutorRepositoy autorRepository; 

   public AutorService(AutorRepositoy autorRepository){
        this.autorRepository = autorRepository;
   }

   public List<Autor> listAll() {return autorRepository.findAll(); }
   public Autor save(Autor autor) {return autorRepository.save(autor); }
   public void find(Long ID) {autorRepository.findById(ID); }
   public void delete(Long ID) {autorRepository.deleteById(ID);}
   
}
