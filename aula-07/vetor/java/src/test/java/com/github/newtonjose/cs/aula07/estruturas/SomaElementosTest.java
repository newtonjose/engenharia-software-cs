package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomaElementosTest {

    @Test
    void getSomaElementos() {
        int[] vetInt = new int[]{0, 10, 4 , 2, 3, 10, 3};
        assertEquals(2, SomaElementosUtils.getSomaElementos(10, vetInt));
    }

    @Test
    void argumentosInvalidos() {
        int[] t = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> SomaElementosUtils.getSomaElementos(10, t)
        );
    }
}