package com.example.CodexisMusic.Modelos;

import java.util.ArrayList;


public class Playlist {
    private String nome;
    private ArrayList<Musica> listaDeMusica = new ArrayList<>();

    public void listarMusica(){

    }

    public String getNome() {
        return nome;
    }
    public ArrayList getListaDeMusica(){
        return listaDeMusica;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setListaDeMusica(ArrayList<Musica> listaDeMusica) {
        this.listaDeMusica = listaDeMusica;
    }
    @Override
    public String toString() {
        return 1+1 + " - " ;
    }
}
