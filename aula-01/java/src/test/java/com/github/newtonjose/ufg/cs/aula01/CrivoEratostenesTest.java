package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrivoEratostenesTest {

    @Test
    void calculaCrivoCorreto() {
        int[] a = new int[] {0, 0, 0, 0, 0};
        assertTrue(Algoritmos.calculaCrivoEratostenes( a.length-1, a));
    }

    @Test
    void verificaArgumentosInvalidos() {
        int[] a = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaCrivoEratostenes(
                        a.length-1, a));

        int[] b = new int[] {0, 0, 0, 1, 0};
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaCrivoEratostenes(
                        b.length-1, b));
    }
}
