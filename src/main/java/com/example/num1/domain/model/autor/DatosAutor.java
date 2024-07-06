package com.example.num1.domain.model.autor;

import jakarta.validation.constraints.NotNull;

public record DatosAutor(
        @NotNull String nombre,
        @NotNull String nacionalidad
) {
}
