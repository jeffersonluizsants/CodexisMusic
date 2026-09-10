package com.example.CodexisMusic.Modelos;

public class Audio {
    private double totalDeReproducoes;
    private double totalcurtidas;
    private double classificacao;

    public void curte(){
       totalcurtidas++;
    }

    public void reproduz(){
        totalDeReproducoes++;
    }

    public double getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public double getTotalcurtidas() {
        return totalcurtidas;
    }

    public double getClassificacao() {
        return classificacao;
    }


}
