package com.example.num1.infra.errores;

import org.springframework.validation.FieldError;

public record DatosErrores(String login, String clave) {
    public DatosErrores(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
