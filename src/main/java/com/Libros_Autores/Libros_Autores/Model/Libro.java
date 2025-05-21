package com.Libros_Autores.Libros_Autores.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Libro")
public class Libro {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "anioPublicacion")
    private int anioPublicacion;

    /**
     * Relación Muchos a uno
     * Uno o varios libros pertenecen a un autor
     *
     * Usamos el @JoinColumn para marcar la foregn key de la tabla libros
     * que es el autor_id
     *
     * Llamamos al modelo de Autor mediante una variable identificativa llamada
     * autor
     *
     * (Revisar)
     * Usamos @JsonManagedReference y @JsonBackReference para evitar
     * que en las consultas JSON haya bucles infinitos y marcar la relación
     * entre el autor y el libro, también evita que aparezca un error llamado StackOverflowError
     *
     * @JsonManagedReference Señala al padre de la relación, un autor puede tener varios libros
     * @JsonBackReference Señala al hijo de la relación, un libro pertenece a un único autor
    */
    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    private Autor autor;

    //CONSTRUCTOR
    public Libro(){}

    public Libro(Long id, String titulo, String isbn, int anioPublicacion, Autor autor){
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    //GETTER Y SETTER

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
