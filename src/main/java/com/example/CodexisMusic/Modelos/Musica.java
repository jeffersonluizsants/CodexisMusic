package com.example.CodexisMusic.Modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo da música é obrigatorio")
    @Size(min = 1, max = 100, message = "O titulo deve ter entre 1 a 100 caracteres")
    private String titulo;

    @NotBlank(message = "O álbum é obirgatorio")
    private String album;

    @NotBlank(message = "O artista é obrigatório")
    private String artista;

    private String genero;

    public Musica() {}

    public Musica(String titulo, String album, String artista, String genero) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}