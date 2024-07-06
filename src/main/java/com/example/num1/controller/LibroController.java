package com.example.num1.controller;


import com.example.num1.domain.model.autor.DatosMostrarAutor;
import com.example.num1.domain.model.libro.DatosActualizar;
import com.example.num1.domain.model.libro.DatosLibros;
import com.example.num1.domain.model.libro.DatosMostrarLibro;
import com.example.num1.domain.model.libro.Libro;
import com.example.num1.domain.repository.RepositoryLibro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private RepositoryLibro repositoryLibro;

    @GetMapping("/mostrar")
    public ResponseEntity<Page<DatosMostrarLibro>> mostrar(@PageableDefault(size = 4)Pageable pageable){
        return ResponseEntity.ok(repositoryLibro.findByActivoTrue(pageable).map(DatosMostrarLibro::new));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity usuario(@PathVariable Long id){
        var libro =repositoryLibro.getReferenceById(id);
        return ResponseEntity.ok(new DatosMostrarLibro(libro.getId(), libro.getTitulo(), libro.getIdioma(),
                new DatosMostrarAutor(libro.getAutor().getNombre(),libro.getAutor().getNacionalidad())));
    }

    @PostMapping("/crear")
    public ResponseEntity<DatosMostrarLibro> crear(@RequestBody @Valid DatosLibros datosLibros, UriComponentsBuilder uriComponentsBuilder){
        var libro=repositoryLibro.save(new Libro(datosLibros));
        URI url=uriComponentsBuilder.path("/libro/usuario/{id}").buildAndExpand(libro.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosMostrarLibro(libro.getId(), libro.getTitulo(), libro.getIdioma(),
                new DatosMostrarAutor(libro.getAutor().getNombre(),libro.getAutor().getNacionalidad())));
    }

    @PutMapping("/actualizar/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id,@RequestBody DatosActualizar datosActualizar){
        var libro=repositoryLibro.getReferenceById(id);
        libro.actualizar(datosActualizar);
        return ResponseEntity.ok(new DatosMostrarLibro(libro.getId(), libro.getTitulo(), libro.getIdioma(),
                new DatosMostrarAutor(libro.getAutor().getNombre(),libro.getAutor().getNacionalidad())));
    }


    @DeleteMapping("/borrar/{id}")
    @Transactional
    public ResponseEntity borrar(@PathVariable Long id){
        var libro=repositoryLibro.getReferenceById(id);
        libro.ocultar();
        return ResponseEntity.noContent().build();
    }

}
