package com.example.CodexisMusic.servico;
import com.example.CodexisMusic.Modelos.Musica;
import com.example.CodexisMusic.Modelos.Playlist;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PlaylistService {
   private final ArrayList<Playlist> listaDePlaylists = new ArrayList<>();
   private final MusicaService musicaService;

    public PlaylistService(MusicaService musicaService) {
        this.musicaService = musicaService;
    }


    public void adicionarPlaylist(String nomeDaPlaylist){
        Playlist novaPlaylist = new Playlist();
        novaPlaylist.setNome(nomeDaPlaylist);
        listaDePlaylists.add(novaPlaylist);
    }

    public void listarPlaylist(){
        if (listaDePlaylists.isEmpty()){
            System.out.println("Lista de playlist vazias");
        }else {
            for (Playlist lista : listaDePlaylists){
                System.out.println(lista);
            }
        }

    }
    public void excluirPlaylist(String nomeParaExluir){
        if (listaDePlaylists.isEmpty()) {
            System.out.println("Lista de playlist vazias");
            return;
        }

        Iterator<Playlist> iterator = listaDePlaylists.iterator();
        boolean encontrada = false;
            while (iterator.hasNext()){
                Playlist lista = iterator.next();
                if (lista.getNome().equalsIgnoreCase(nomeParaExluir)){
                    iterator.remove();
                    encontrada = true;
                    System.out.println("Playlist" + nomeParaExluir + " exluida com sucesso!");
                    break;
                }
            }
            if (!encontrada){
                System.out.println("Playlist não encontrada");
            }

        }
    public void removerMusicaDaPlaylist(Playlist playlist, String nomeDaMusicaParaExlusao){
        if (playlist.getListaDeMusica().isEmpty()){
            System.out.println("Playlist de Musica vazia");
            return;
        }
        Iterator<Musica> iteratorMusica = playlist.getListaDeMusica().iterator();
        boolean musicaEncontrada = false;
        while (iteratorMusica.hasNext()){
            Musica play = iteratorMusica.next();
            if (play.getTitulo().equalsIgnoreCase(nomeDaMusicaParaExlusao)){
                iteratorMusica.remove();
                musicaEncontrada = true;
                System.out.println("Musica "+ nomeDaMusicaParaExlusao + " exluida coom sucesso!");
                break;

            }
            }
        if (!musicaEncontrada){
            System.out.println("Musica não encontrada");
        }
    }
    public Playlist econtrarPlaylistPorNome(String nomePlayist){
        if(listaDePlaylists.isEmpty()){
            System.out.println("Você não tem playlist criadas");
            return null;
        }
        for (Playlist play : listaDePlaylists){
            if (play.getNome().equalsIgnoreCase(nomePlayist)){
                return play;
            }
            }
            System.out.println("Playlist não encontrada");
            return null;
    }
    public void adicionarMusicaNaPlaylist(Musica musicaParaAdicionar, Playlist playlist) {
        if (playlist != null && musicaParaAdicionar != null) {
            playlist.getListaDeMusica().add(musicaParaAdicionar);
            System.out.println("Musica adicionada com sucesso");
            playlist.getListaDeMusica();
        }else {
            System.out.println("Não foi possivel adicionar a musica");
        }
    }
    public Playlist listarMusicasDaPlaylist(Playlist playlist){

        return null;
    }

    }
