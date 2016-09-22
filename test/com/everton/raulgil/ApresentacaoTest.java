package com.everton.raulgil;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by everton on 22/09/16.
 */
public class ApresentacaoTest {

    @Test
    public void testAddNota() throws Exception {
        double nota = 0.0;
        String nome = "Thelonoius";
        LocalDate dataNasc = LocalDate.of(1917, 10, 10);

        Jurado j = new Jurado(nome, dataNasc);
        Apresentacao ap = new Apresentacao("Rodada 1", "Primeira apresentação dos calouros");

        nota = 6.5;

        ap.addNota(j, nota);

        Assert.assertEquals(6.5, ap.getNotaDoJurado(j), 0.5);
    }
}