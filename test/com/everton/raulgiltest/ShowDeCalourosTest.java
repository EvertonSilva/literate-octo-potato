package com.everton.raulgiltest;

import com.everton.raulgil.Apresentacao;
import com.everton.raulgil.Calouro;
import com.everton.raulgil.Jurado;
import com.everton.raulgil.ShowDeCalouros;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by everton on 16/09/16.
 */
public class ShowDeCalourosTest {

    private Calouro c = new Calouro();
    private Jurado j = new Jurado();
    private ShowDeCalouros s = new ShowDeCalouros();

    private ArrayList<Calouro> kalouros = new ArrayList<>();

    private double[] notasC1 = {7.1, 6.8, 7.3, 7.5, 8.0}; // media = 7.34
    private double[] notasC2 = {7.7, 8.8, 7.6, 8.5, 8.2}; // media = 8.16
    private double[] notasC3 = {6.7, 6.8, 6.6, 9.5, 9.2}; // media = 7.76

    private Random r = new Random();

    @Before
    public void setUp() {
        // preenche dados do calouro
        c.setNome("Everton");
        c.setCpf("321054278-39");

        // preenche dados do jurado
        j.setNome("Theolonius Monk");
        j.setDataNasc(LocalDate.of(1917, 10, 10));



        // Adiciona 3 calouros
        for(int j = 0; j < 3; j++) {
            String nome = "Calouro " + (char)(j+65);
            String cpf = "111000222-3"+j;
            LocalDate dataNasc = LocalDate.of(1975+j, 4+j, 1+j);

            Calouro c = new Calouro(nome, cpf, dataNasc);
            c.addApresentacao(new Apresentacao("Apresentação 1", "Primeira apresentação"));

            kalouros.add(c);
        }

    }

    @After
    public void tearDown() throws Exception {
        c = null;
        s = null;
    }

    @Test
    public void testInserirCalouro() throws Exception {
        int numCalouros = s.getNumeroCalouros();
        s.addParticipante(c);

        assertEquals((numCalouros+1), s.getNumeroCalouros());
    }

    @Test
    public void testInserirJurado() throws Exception {
        int numJurados = s.getNumeroJurados();
        s.addParticipante(j);
        assertEquals((numJurados+1), s.getNumeroJurados());
    }

    @Test
    public void testGetCalouroPorCpf() throws Exception {
        String cpf = "321054278-39";
        s.addParticipante(c);
        Calouro outroCalouro = s.getCalouroPorCpf(cpf);

        assertEquals(c, outroCalouro);
    }

    @Test
    public void testGetJuradoNaPosicao() throws Exception {
        s.addParticipante(j);
        Jurado j2 = s.getJuradoNaPosicao(0);

        assertEquals(j, j2);
    }

    @Test
    public void testMostarVencedores() throws Exception {

        double[][] notas = new double[3][5];
        notas[0] = notasC1;
        notas[1] = notasC2;
        notas[2] = notasC3;

        // Adiciona 5 jurados
        for(int i = 0; i < 5; i++) {
            String nome = "Jurado " + (char)(i+65);
            LocalDate dataNasc = LocalDate.of(1975+i, 4+i, 1+i);
            Jurado j = new Jurado(nome, dataNasc);
            s.addParticipante(j);
        }

        s.addParticipante(kalouros.get(0));
        s.addParticipante(kalouros.get(1));
        s.addParticipante(kalouros.get(2));

        int indiceCalouro = 0;
        for(Calouro c : s) {
            // preenche o mapa de notas da Apresentação
            for(int k = 0; k < s.getNumeroJurados(); k++) {
                c.getApresentacaoNaPosicao(0).addNota(s.getJuradoNaPosicao(k), notas[indiceCalouro][k]);
            }
            indiceCalouro++;
        }

        List<Calouro> ranking = s.getVencedores();

        assertEquals(kalouros.get(1), ranking.get(0));
        assertTrue(kalouros.get(0).getMedia() < ranking.get(0).getMedia());
        assertTrue(kalouros.get(2).getMedia() < ranking.get(0).getMedia());
    }
}