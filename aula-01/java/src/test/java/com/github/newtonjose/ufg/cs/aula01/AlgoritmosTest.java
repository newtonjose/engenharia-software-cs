package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmosTest {

    @Test
    void calculaCrivoErastostenes() {
    }

    @Test
    void getDiaDaSemana() {
    }

    @Test
    void calculaFatorial() {
    }

    @Test
    void fibonacci() {
    }

    @Test
    void regraHorner() {
    }

    @Test
    void calculaLogNatural() {
    }

    @Test
    void maiorDivisorComum() {
    }

    @Test
    void maiorDivisorComumSemResto() {
    }

    @Test
    void numeroPi() {
    }

    @Test
    void numeroPrimo() {
    }

    @Test
    void calculaPotencia() {
    }

    @Test
    void calculaProdutoInteiros() {
        // Calcula valor correto
        assertEquals(8, AlgoritmosMatematicos.calculaProdutoInteiros(4, 2));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.calculaProdutoInteiros(-1, 4));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.calculaProdutoInteiros(1, -1));
    }

    @Test
    void verificaPropriedade153() {
    }

    @Test
    void verificaPropriedade3025() {
    }

    @Test
    void calculaQuadradoPerfeito() {

        // caso de sucesso
        assertTrue(AlgoritmosMatematicos.verificaQuadradoPerfeito(4));

        // caso falso
        assertFalse(AlgoritmosMatematicos.verificaQuadradoPerfeito(3));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.verificaQuadradoPerfeito( 0));
    }

    @Test
    void raizQuadrada() {
    }

    @Test
    void calculaRazaoAurea() {
    }

    @Test
    void calculaRestoDivisao() {

        // calcula valor correto
        assertEquals(0, AlgoritmosMatematicos.calculaRestoDivisao(10,2));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.calculaRestoDivisao( -1,10));
    }

    @Test
    void somaNaturais() {
    }

    @Test
    void validaCPFRegraHorner() {
    }

}