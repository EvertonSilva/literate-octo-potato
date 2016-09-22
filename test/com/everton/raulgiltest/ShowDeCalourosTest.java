package com.everton.raulgiltest;

import com.everton.raulgil.Calouro;
import com.everton.raulgil.Jurado;
import com.everton.raulgil.ShowDeCalouros;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by everton on 16/09/16.
 */
public class ShowDeCalourosTest {

    @Test
    public void testInserirCalouro() throws Exception {
        Calouro c = new Calouro();
        c.setNome("Everton");
        c.setCpf("321054278-39");

        ShowDeCalouros s = new ShowDeCalouros();
        s.addCalouro(c);

        Assert.assertEquals(1, s.getNumeroCalouros());
    }

    @Test
    public void testInserirJurado() throws Exception {
        Jurado j = new Jurado();
        j.setNome("Theolonius Monk");

        ShowDeCalouros s = new ShowDeCalouros();
        s.addJurado(j);

        Assert.assertEquals(1, s.getNumeroJurados());
    }

    @Test
    public void testGetCalouroPorCpf() throws Exception {
        String cpf = "321054278-39";
        Calouro c = new Calouro();
        ShowDeCalouros s = new ShowDeCalouros();

        c.setNome("Everton");
        c.setCpf(cpf);

        s.addCalouro(c);

        Calouro outroCalouro = s.getCalouroPorCpf(cpf);

        Assert.assertEquals(c, outroCalouro);
    }

    @Test
    public void testGetJuradoNaPosicao() throws Exception {
        ShowDeCalouros s = new ShowDeCalouros();

        Jurado j = new Jurado();

        j.setNome("Thelonious Monk");
        j.setDataNasc(LocalDate.of(1917, 10, 10));

        s.addJurado(j);

        Jurado j2 = s.getJuradoNaPosicao(0);

        Assert.assertEquals(j, j2);
    }
}