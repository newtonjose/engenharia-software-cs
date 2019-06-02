package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PotenciaTest {

    @Test
    void calculaPotenciaCorreta() {
        assertEquals(16, Algoritmos.calculaPotencia(2, 4, 1, 1));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaPotencia(0, 4, 1, 1));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaPotencia(2, 0, 1, 1));
    }

}