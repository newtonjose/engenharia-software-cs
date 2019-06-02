package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumeroPiTest {
    @Test
    void calculaNumeroPiAproximado() {
        assertEquals(3.140592653839794, Algoritmos.numeroPi(1000));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.numeroPi(0));
    }
}
