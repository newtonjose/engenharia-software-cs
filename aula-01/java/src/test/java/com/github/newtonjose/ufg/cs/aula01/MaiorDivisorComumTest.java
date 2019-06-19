package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MaiorDivisorComumTest {
    @Test
    void maiorDivisorComumCorreto() {
        assertEquals(2, AlgoritmosUtils.maiorDivisorComum(4,
                2));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.maiorDivisorComum(2, -2));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.maiorDivisorComum(2, 4));
    }
}