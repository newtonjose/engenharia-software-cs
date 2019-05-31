package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaiorDivisorComumSemRestoTest {
    @Test
    void maiorDivisorComumSemRestoCorreto() {
        assertEquals(2, Algoritmos.maiorDivisorComumSemResto(4,
                2));

        assertEquals(2, Algoritmos.maiorDivisorComumSemResto(4,
                2));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.maiorDivisorComumSemResto(2, -2));
    }
}
