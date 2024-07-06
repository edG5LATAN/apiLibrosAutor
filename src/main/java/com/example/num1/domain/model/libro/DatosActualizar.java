package com.example.num1.domain.model.libro;

import com.example.num1.domain.model.autor.DatosAutor;
import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosActualizar(
        String titulo,
        String idioma,
        @JsonAlias("autor") DatosAutor datosAutor
) {
}
