package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PotenciaTest {

    @Test
    void calculaPotenciaCorreta() {
        assertEquals(16, AlgoritmosMatematicos.calculaPotencia(2, 4));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.calculaPotencia(0, 4));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.calculaPotencia(2, 0));
    }

}