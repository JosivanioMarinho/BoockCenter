package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.biblioteca.models.Llivro;

@Repository
public interface LivroRepository extends JpaRepository<Llivro, String>{

}
