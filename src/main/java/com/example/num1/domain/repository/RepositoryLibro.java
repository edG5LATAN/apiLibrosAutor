package com.example.num1.domain.repository;

import com.example.num1.domain.model.libro.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RepositoryLibro extends JpaRepository<Libro,Long> {
    Page<Libro> findByActivoTrue(Pageable pageable);
}
