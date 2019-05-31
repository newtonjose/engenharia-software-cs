package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RaizQuadradaTest {
    @Test
    void casoSucesso() {
        assertEquals(2, Algoritmos.raizQuadrada(4, 10));
    }

    @Test
    void argumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.raizQuadrada(-1, 10));
    }
}
