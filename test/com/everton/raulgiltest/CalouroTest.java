package com.everton.raulgiltest;

import com.everton.raulgil.Apresentacao;
import com.everton.raulgil.Calouro;
import com.everton.raulgil.Jurado;
import com.everton.raulgil.ShowDeCalouros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by everton on 22/09/16.
 */
public class CalouroTest {

    private double[] notas1 = {7.1, 6.8, 7.3, 7.5, 8.0};
    private double[] notas2 = {7.7, 8.8, 7.6, 8.5, 8.2};
    private Calouro c = new Calouro();
    private ShowDeCalouros s = new ShowDeCalouros();
    private Apresentacao a1 = new Apresentacao("1a Apresentação", "Lorem ipsum");
    private Apresentacao a2 = new Apresentacao("2a Apresentação", "Ipsum lorem");

    @Before
    public void setUp() throws Exception {

        // adiciona 5 jurados ao show
        for(int i = 0; i < 5; i++) {
            String nome = "Jurado " + (char)(i+65);
            LocalDate dataNasc = LocalDate.of(1975+i, 4+i, 1+i);
            Jurado j = new Jurado(nome, dataNasc);
            s.addParticipante(j);
        }

        // preenche o mapa de notas da Ap1 e Ap2
        for(int k = 0; k < s.getNumeroJurados(); k++) {
            a1.addNota(s.getJuradoNaPosicao(k), notas1[k]);
            a2.addNota(s.getJuradoNaPosicao(k), notas2[k]);
        }

        // adiciona apresentações ao calouro
        c.addApresentacao(a1);
        c.addApresentacao(a2);
    }

    @Test
    public void testCalcMedia() throws Exception {
        double mediaGeralCalouro = (calcMedia(notas1) + calcMedia(notas2)) / 2;
        c.calcMedia();
        Assert.assertEquals(mediaGeralCalouro, c.getMedia(), 0.0001);
    }

    // Helper para calcular a media de um conjunto de notas
    private double calcMedia(double[] n) {
        double media = 0.0;
        for(Double i : n)
            media += i;
        return media / n.length;
    }

}