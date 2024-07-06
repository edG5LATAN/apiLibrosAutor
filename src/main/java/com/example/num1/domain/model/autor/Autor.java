package com.example.num1.domain.model.autor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "autores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nacionalidad;

    public Autor(DatosAutor datosAutor) {
        this.nombre=datosAutor.nombre();
        this.nacionalidad= datosAutor.nacionalidad();
    }

    public void actualizar(DatosAutor datosAutor) {
        if(datosAutor.nombre()!=null){
            this.nombre= datosAutor.nombre();
        }if(datosAutor.nacionalidad()!=null){
            this.nacionalidad=datosAutor.nacionalidad();
        }
    }
}
