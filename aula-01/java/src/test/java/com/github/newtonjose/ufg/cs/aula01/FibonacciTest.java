package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {
    @Test
    void calculaFibonacciCorreto() {

        assertEquals(0, AlgoritmosUtils.fibonacci(0));

        assertEquals(1, AlgoritmosUtils.fibonacci(1));

        assertEquals(21, AlgoritmosUtils.fibonacci(8));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.fibonacci(-1));
    }
}
