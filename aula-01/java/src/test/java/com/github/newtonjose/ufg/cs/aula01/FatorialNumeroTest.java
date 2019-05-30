package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FatorialNumeroTest {

    @Test
    void calculaFatorialCorreto() {
        assertEquals(6, AlgoritmosMatematicos.calculaFatorial(3));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosMatematicos.calculaFatorial(0));
    }
}
