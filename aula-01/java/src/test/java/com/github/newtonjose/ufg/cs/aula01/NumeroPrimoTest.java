package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumeroPrimoTest {

    @Test
    void verificaNumeroPrimoCorreto() {
        assertTrue(AlgoritmosUtils.numeroPrimo(2));
    }

    @Test
    void verificaNumeroPrimoIncorreto() {
        assertFalse(AlgoritmosUtils.numeroPrimo(4));
    }
    @Test
    void entradaArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.numeroPrimo(0));
    }
}
