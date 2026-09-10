package com.example.CodexisMusic.Dtos;

import com.example.CodexisMusic.Modelos.Musica;

public record MusicaResponseDTO(
        Long id,
        String titulo,
        String album,
        String artista,
        String genero
) {
    public MusicaResponseDTO(Musica musica){
        this(musica.getId(),musica.getTitulo(), musica.getAlbum(), musica.getArtista(), musica.getGenero());
    }
}
