package com.example.num1.domain.model.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosUsuario(
        @NotNull String login,
        @NotNull String clave
) {
}
