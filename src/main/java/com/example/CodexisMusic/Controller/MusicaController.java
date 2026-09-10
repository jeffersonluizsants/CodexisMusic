package com.example.CodexisMusic.Controller;

import com.example.CodexisMusic.Dtos.MusicaRequestDTO;
import com.example.CodexisMusic.Dtos.MusicaResponseDTO;
import com.example.CodexisMusic.Modelos.Musica;
import com.example.CodexisMusic.servico.MusicaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping
    public ResponseEntity<List<MusicaResponseDTO>> listarTodas() {
        List<MusicaResponseDTO> musicas = musicaService.listarMusicas()
                .stream()
                .map(MusicaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<MusicaResponseDTO> buscarPorNome(@PathVariable String nome) {
        Musica musica = musicaService.econtrarbuscarMusicaPorNome(nome);
        if (musica != null) {
            return ResponseEntity.ok(new MusicaResponseDTO(musica));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MusicaResponseDTO> cadastrar(@Valid @RequestBody MusicaRequestDTO dto) {
        Musica novaMusica = new Musica(dto.titulo(),dto.album(),dto.artista(),dto.genero());
        Musica musicaSalva = musicaService.salvar(novaMusica);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MusicaResponseDTO(musicaSalva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaResponseDTO> atualizar(@PathVariable Long id,@Valid @RequestBody MusicaResponseDTO dto){
        Musica musicaParaAtualizar = new Musica(dto.titulo(), dto.album(), dto.artista(), dto.genero());
        Musica musicaAtualizada = musicaService.atualizar(id,musicaParaAtualizar);
        if (musicaAtualizada != null){
            return ResponseEntity.ok(new MusicaResponseDTO(musicaAtualizada));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        boolean deletado = musicaService.deletar(id);
        if (deletado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}