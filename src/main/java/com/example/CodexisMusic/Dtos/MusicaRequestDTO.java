package com.example.CodexisMusic.Dtos;

import jakarta.validation.constraints.NotBlank;

public record MusicaRequestDTO(

        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "O álbum é obrigatório")
        String album,

        @NotBlank(message = "O artista é obrigatório")
        String artista,

        String genero
){}
