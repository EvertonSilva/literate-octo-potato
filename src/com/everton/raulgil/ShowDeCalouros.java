package com.everton.raulgil;

import java.util.*;
import java.util.function.Consumer;

/**
 * Classe para definir um Show De Calouros
 * Created by everton on 14/09/16.
 */
public class ShowDeCalouros implements Iterable<Calouro> {
    private ArrayList<Calouro> calouros = new ArrayList<>();
    private ArrayList<Jurado> jurados = new ArrayList<>();

    public ShowDeCalouros() {
    }


    /**
     * Adiciona um Calouro  ou Jurado ao ArrayList de correspondente
     *
     * @param obj             Object a ser adicionado no ArrayList
     */
    public void addParticipante(Object obj) throws InputMismatchException {
        if(obj instanceof Calouro)
            calouros.add((Calouro) obj);
        else if(obj instanceof Jurado)
            jurados.add((Jurado) obj);
        else
            throw new InputMismatchException("Tipo de dado não suportado.");
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
     * Retorna o total de jurados do Show de Calouros
     *
     * @return              numero de jurados do Show de Calouros
     */
    public int getNumeroJurados() {
        return jurados.size();
    }

    /**
     * Método para retornar um jurado a partir de um índice
     *
     * @param i indice do jurado na ArrayList jurados
     * @return Jurado na posição especificada
     */
    public Jurado getJuradoNaPosicao(int i) {
        return jurados.get(i);
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

    /**
     * Método para criar lista de exibição dos calouros
     *
     * @return String com todos os calouros
     */
    public String listarCalouros(List<Calouro> lc) {
        String listaDeCalouros = "";

        if(lc == null) {
            lc = this.calouros;
        }

        for(Calouro c : lc) {
            listaDeCalouros += "Nome: "+ c.getNome() +
                    "\nCPF: " + c.getCpf() +
                    "\nMédia: " + c.getMedia() + "\n";
        }

        return listaDeCalouros;
    }

    /**
     * Método para mostrar os 3 primeiros colocados
     * @return Listagem de calouros vencedores
     */
    public List<Calouro> getVencedores() {
        List<Calouro> ranking = new ArrayList<Calouro>();

        Collections.sort(calouros);
        ranking = calouros.subList(0, 2);

        return ranking;
    }
    @Override
    public Iterator<Calouro> iterator() {
        return calouros.iterator();
    }
}
