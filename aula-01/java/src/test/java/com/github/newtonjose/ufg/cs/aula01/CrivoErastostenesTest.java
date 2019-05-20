package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrivoErastostenesTest {
    @Test
    void criarObjetoDaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new CrivoErastostenes());
    }

    @Test
    void calculaCrivoCorreto() {
        int[] a = new int[] {0, 0, 0, 0, 0};
        assertTrue(CrivoErastostenes.calculaCrivoErastostenes(a, a.length-1));
    }

    @Test
    void verificaArgumentosInvalidos() {
        int[] a = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> CrivoErastostenes.calculaCrivoErastostenes(a,
                        a.length-1));

        int[] b = new int[] {0, 1, 0, 0, 0};
        assertThrows(IllegalArgumentException.class,
                () -> CrivoErastostenes.calculaCrivoErastostenes(b,
                        b.length-1));
    }
}
