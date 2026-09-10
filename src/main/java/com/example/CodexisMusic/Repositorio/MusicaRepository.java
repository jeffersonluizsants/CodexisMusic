package com.example.CodexisMusic.Repositorio;

import com.example.CodexisMusic.Modelos.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    Musica findByTituloIgnoreCase(String titulo);
}