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

    public void addCalouro(Calouro c) {
        calouros.add(c);
    }

    public int getNumeroCalouros() {
        return calouros.size();
    }

    public void addJurado(Jurado j) {
        jurados.add(j);
    }

    public int getNumeroJurados() {
        return jurados.size();
    }
}
