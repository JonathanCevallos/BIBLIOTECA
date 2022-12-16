package com.uteq.biblioteca.repositories;

import com.uteq.biblioteca.entities.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario,Integer> {
}
