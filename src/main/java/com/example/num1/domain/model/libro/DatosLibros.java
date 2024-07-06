package com.example.num1.domain.model.libro;

import com.example.num1.domain.model.autor.DatosAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DatosLibros(
        @NotNull String titulo,
        @NotNull String idioma,
        @NotNull @JsonAlias("autor") DatosAutor datosAutor
) {
}
