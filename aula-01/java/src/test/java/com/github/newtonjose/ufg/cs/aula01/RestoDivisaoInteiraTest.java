package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe para teste de unidade com corbetura de 100%.
 */
class RestoDivisaoInteiraTest {

    @Test
    void calculaRestoDivisaoCorreto() {
        assertEquals(0, RestoDivisaoInteira.calculaRestoDivisao(10,
                5));
    }

    @Test
    void calculaRestoDivisaoArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> RestoDivisaoInteira.calculaRestoDivisao(10, -5));

        assertThrows(IllegalArgumentException.class,
                () -> RestoDivisaoInteira.calculaRestoDivisao(10, 0));

        assertThrows(IllegalArgumentException.class,
                () -> RestoDivisaoInteira.calculaRestoDivisao(-1, 10));

        assertThrows(IllegalArgumentException.class,
                () -> RestoDivisaoInteira.calculaRestoDivisao(-1, 0));
    }

    @Test
    void criarObjetoDaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new RestoDivisaoInteira());
    }

}