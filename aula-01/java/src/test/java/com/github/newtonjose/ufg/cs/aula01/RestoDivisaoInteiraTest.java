package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RestoDivisaoInteiraTest {

    @Test
    void calculaRestoDivisaoArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaRestoDivisao(10, -5));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaRestoDivisao(10, 0));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaRestoDivisao(-1, 10));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaRestoDivisao(-1, 0));
    }
}
