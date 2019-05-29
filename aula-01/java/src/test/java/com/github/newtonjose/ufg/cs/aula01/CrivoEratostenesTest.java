package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrivoEratostenesTest {

    @Test
    void calculaCrivoCorreto() {
        int[] a = new int[] {0, 0, 0, 0, 0};
        assertTrue(Algoritmos.calculaCrivoEratostenes(a, a.length-1));
    }

    @Test
    void verificaArgumentosInvalidos() {
        int[] a = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaCrivoEratostenes(a,
                        a.length-1));

        int[] b = new int[] {0, 0, 0, 1, 0};
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaCrivoEratostenes(b,
                        b.length-1));
    }
}
