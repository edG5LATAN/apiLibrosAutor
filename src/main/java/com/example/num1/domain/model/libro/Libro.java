package com.example.num1.domain.model.libro;

import com.example.num1.domain.model.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id-Autores")
    private Autor autor;
    private Boolean activo;

    public Libro(DatosLibros datosLibros) {
        this.titulo= datosLibros.titulo();
        this.idioma= datosLibros.idioma();
        this.autor= new Autor(datosLibros.datosAutor());
        this.activo=true;
    }

    public void actualizar(DatosActualizar datosActualizar) {
        if(datosActualizar.titulo()!=null){
            this.titulo= datosActualizar.titulo();
        }if(datosActualizar.idioma()!=null){
            this.idioma= datosActualizar.idioma();
        }
        if(datosActualizar.datosAutor()!=null){
            var aut= new Autor();
            aut.actualizar(datosActualizar.datosAutor());
            this.autor=aut;
        }
    }

    public void ocultar() {
        this.activo=false;
    }
}
