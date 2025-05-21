package com.Libros_Autores.Libros_Autores.Model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Autor")
public class Autor {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nacionalidad")
    private String nacionalidad;

    /**
     * Relación uno a muchos
     * Un autor puede escribir muchos libros
     * Creamos una lista que llame al modelo Libro con una
     * variable identificativa llamada libros.
     *
     * (Revisar)
     * Usamos @JsonManagedReference y @JsonBackReference para evitar
     * que en las consultas JSON haya bucles infinitos y marcar la relación
     * entre el autor y el libro, también evita que aparezca un error llamado StackOverflowError
     *
     * @JsonManagedReference Señala al padre de la relación, un autor puede tener varios libros
     * @JsonBackReference Señala al hijo de la relación, un libro pertenece a un único autor
    */

    @OneToMany(mappedBy = "autor")
    @JsonManagedReference
    private List<Libro> libros;

    // CONSTRUCTOR SIN PARÁMETROS
    public Autor(){}

    // CONSTRUCTOR PRINCIPAL CON PARÁMETROS
    public Autor(Long ID, String nombre, String nacionalidad, List<Libro> libros){
        this.ID = ID;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = libros;
    }

    //GETTERS Y SETTERS

    public List<Libro> getLibro(){
        return libros;
    }

    public void setLibro(List<Libro> libros){
        this.libros = libros;
    }

    public long getID(){
        return ID;
    }

    public void setID(long ID){
        this.ID = ID;
    }
    
    public String getNacionalidad(){
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
