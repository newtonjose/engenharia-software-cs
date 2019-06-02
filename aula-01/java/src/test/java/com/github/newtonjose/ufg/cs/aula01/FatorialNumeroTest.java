package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FatorialNumeroTest {

    @Test
    void calculaFatorialCorreto() {
        assertEquals(6, Algoritmos.fatorial(3, 1, 2));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.fatorial(0, 1, 2));
    }
}
