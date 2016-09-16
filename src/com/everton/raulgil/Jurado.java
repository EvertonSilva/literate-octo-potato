package com.everton.raulgil;

import java.time.LocalDate;

/**
 * Created by everton on 14/09/16.
 */
public class Jurado {
    private String nome;
    private LocalDate dataNasc;

    public Jurado() {
    }

    public Jurado(String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}
