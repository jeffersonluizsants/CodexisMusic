package com.example.CodexisMusic.servico;

import com.example.CodexisMusic.Modelos.Musica;
import com.example.CodexisMusic.Repositorio.MusicaRepository; // Import em português
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    private final MusicaRepository repository;

    public MusicaService(MusicaRepository repository) {
        this.repository = repository;
    }

    public List<Musica> listarMusicas() {
        return repository.findAll();
    }

    public Musica econtrarbuscarMusicaPorNome(String nomeMusica) {
        return repository.findByTituloIgnoreCase(nomeMusica);
    }

    public Musica salvar(Musica novaMusica) {
        return repository.save(novaMusica);
    }
    public Musica atualizar(Long id, Musica musicaAtualizada){
        Musica musicaExistente = repository.findById(id).orElse(null);

        if (musicaExistente != null){
            musicaExistente.setTitulo(musicaAtualizada.getTitulo());
            musicaExistente.setAlbum(musicaAtualizada.getAlbum());
            musicaExistente.setArtista(musicaAtualizada.getArtista());
            musicaExistente.setGenero(musicaAtualizada.getGenero());
            return repository.save(musicaExistente);
        }

        return null;
    }
    public boolean deletar (Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}