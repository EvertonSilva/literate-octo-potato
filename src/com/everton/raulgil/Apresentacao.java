package com.everton.raulgil;

import java.util.HashMap;

/**
 * Created by everton on 14/09/16.
 */
public class Apresentacao {
    double media;
    private String titulo;
    private String descricao;
    private HashMap<Jurado, Double> notasJurados = new HashMap();

    public Apresentacao() {
    }

    public Apresentacao(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public double getMedia() {
        return media;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addNota(Jurado j, double n) {
        notasJurados.put(j, n);
    }

    public double getNotaDoJurado(Jurado j) {
        return notasJurados.get(j);
    }

    public void calcMedia() {
        media = 0.0;
        notasJurados.forEach((j, n) -> media += n);
        media = media/notasJurados.size();
    }
}
