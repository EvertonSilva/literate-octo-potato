package com.everton.raulgiltest;

import com.everton.raulgil.Apresentacao;
import com.everton.raulgil.Jurado;
import com.everton.raulgil.ShowDeCalouros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by everton on 22/09/16.
 */
public class ApresentacaoTest {

    private ShowDeCalouros s = new ShowDeCalouros();

    @Before
    public void setUp() throws Exception {
        Random r = new Random();
        for(int i = 0; i < 5; i++) {
            String jNome = "Jurado " + (char)(i+65);
            LocalDate jDtNasc = LocalDate.of(1917, 3+i, 10);
            Jurado j = new Jurado(jNome, jDtNasc);
            s.addParticipante(j);
        }
    }

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

    @Test
    public void testCalcMedia() throws Exception {
        Apresentacao ap = new Apresentacao("Titulo", "Descrição");
        double[] notas = {7.1, 6.8, 7.3, 7.5, 8.0};
        double media = 0.0;

        // calcular media
        for(Double n : notas)
            media += n;
        media = media / notas.length;

        for(int i = 0; i < s.getNumeroJurados(); i++) {
            ap.addNota(s.getJuradoNaPosicao(i), notas[i]);
        }

        ap.calcMedia();

        Assert.assertEquals(media, ap.getMedia(), 0.0001);

    }
}