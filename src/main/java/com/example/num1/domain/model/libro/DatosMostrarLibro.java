package com.example.num1.domain.model.libro;

import com.example.num1.domain.model.autor.DatosMostrarAutor;

public record DatosMostrarLibro(
        Long id,
        String titulo,
        String idioma,
        DatosMostrarAutor autor
) {

    public DatosMostrarLibro(Libro libro){
        this(libro.getId(), libro.getTitulo(), libro.getIdioma(), new DatosMostrarAutor(libro.getAutor().getNombre(),
                libro.getAutor().getNacionalidad()));
    }

}
