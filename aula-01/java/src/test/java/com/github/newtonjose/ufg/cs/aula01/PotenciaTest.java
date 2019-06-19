package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PotenciaTest {

    @Test
    void calculaPotenciaCorreta() {
        assertEquals(16, AlgoritmosUtils.calculaPotencia(2, 4));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaPotencia(0, 4));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaPotencia(2, 0));
    }

}