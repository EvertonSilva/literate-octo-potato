package com.everton.raulgil;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by everton on 14/09/16.
 */
public class Calouro implements Comparable {
    double media = 0;
    private String cpf;
    private String nome;
    private LocalDate dataNasc;
    private ArrayList<Apresentacao> apresentacoes = new ArrayList<>();

    public Calouro() {
    }

    public Calouro(String nome) {
        this.nome = nome;
    }

    public Calouro(String cpf, String nome, LocalDate dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addApresentacao(Apresentacao ap) {
        apresentacoes.add(ap);
    }

    public double getMedia() {
        return media;
    }

    public void calcMedia() {
        for(Apresentacao a : apresentacoes) {
            a.calcMedia();
            media += a.getMedia();
        }
        media = media / apresentacoes.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Calouro calouro = (Calouro) obj;

        return cpf != null ? cpf.equals(calouro.cpf) : calouro.cpf == null;

    }

    @Override
    public int compareTo(Object o) {
        Calouro outroCalouro = (Calouro) o;

        // Critério de comparação de dois calouros:
        // as notas maiores devem ser colocadas "na frente"
        // assim ordenamos a lista de calouros por ordem
        // decrescente de notas e evitamos ter que ler
        // os vencedores a partir do final da lista
        if(this.getMedia() > outroCalouro.getMedia())
            return -1;
        else if(this.getMedia() < outroCalouro.getMedia())
            return 1;

        return 0;
    }
}
