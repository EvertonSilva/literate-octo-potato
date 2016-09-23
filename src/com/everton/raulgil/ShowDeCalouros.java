package com.everton.raulgil;

import java.util.ArrayList;

/**
 * Classe para implementar um Show De Calouros
 * Created by everton on 14/09/16.
 */
public class ShowDeCalouros {
    private ArrayList<Calouro> calouros = new ArrayList<>();
    private ArrayList<Jurado> jurados = new ArrayList<>();

    public ShowDeCalouros() {
    }

    /**
     * Adiciona um Calouro ao ArrayList de Calouros
     *
     * @param c             calouro a ser adicionado no ArrayList
     */
    public void addCalouro(Calouro c) {
        calouros.add(c);
    }

    /**
     * Retorna o total de participantes do Show de Calouros
     *
     * @return              numero de particiapantes
     */
    public int getNumeroCalouros() {
        return calouros.size();
    }

    /**
     * Adiciona um jurado ao ArrayList de Jurados
     *
     * @param j             Jurado a ser adicionado no ArrayList
     */
    public void addJurado(Jurado j) {
        jurados.add(j);
    }

    /**
     * Retorna o total de jurados do Show de Calouros
     *
     * @return              numero de jurados do Show de Calouros
     */
    public int getNumeroJurados() {
        return jurados.size();
    }

    /**
     * Retorna o calouro que possui o cpf informado
     *
     * @param cpf           cpf do calouro
     * @return              calouro encontrado no ArrayList
     * @throws Exception    calouro não encontrado
     */
    public Calouro getCalouroPorCpf(String cpf) throws Exception{

        for(Calouro c : calouros) {
            if(c.getCpf().equals(cpf))
                return c;
        }

        throw new Exception("Calouro não encontrado para o CPF informado.");
    }

    public Calouro getCalouroNaPosicao(int i) {
        return calouros.get(i);
    }

    public Jurado getJuradoNaPosicao(int i) {
        return jurados.get(i);
    }

    public String listarCalouros() {
        String listaDeCalouros = "";

        for(Calouro c : calouros) {
            listaDeCalouros += "Nome: "+ c.getNome() +
                    "\nCPF: " + c.getCpf() +
                    "\nMédia: " + c.getMedia() + "\n";
        }

        return listaDeCalouros;
    }
}
