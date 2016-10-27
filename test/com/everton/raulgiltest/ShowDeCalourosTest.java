package com.everton.raulgiltest;

import com.everton.raulgil.Calouro;
import com.everton.raulgil.Jurado;
import com.everton.raulgil.ShowDeCalouros;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by everton on 16/09/16.
 */
public class ShowDeCalourosTest {

    private Calouro c = new Calouro();
    private Jurado j = new Jurado();
    private ShowDeCalouros s = new ShowDeCalouros();

    @Before
    public void setUp() {
        // preenche dados do calouro
        c.setNome("Everton");
        c.setCpf("321054278-39");

        // preenche dados do jurado
        j.setNome("Theolonius Monk");
        j.setDataNasc(LocalDate.of(1917, 10, 10));
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
}