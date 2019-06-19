package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RaizQuadradaTest {
    @Test
    void casoSucesso() {
        assertEquals(2, AlgoritmosUtils.raizQuadrada(4, 10));
    }

    @Test
    void argumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.raizQuadrada(-1, 10));
    }
}
