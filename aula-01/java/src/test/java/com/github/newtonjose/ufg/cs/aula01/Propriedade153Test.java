package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Propriedade153Test {

    @Test
    void propriedade153Satisfaz() {
        assertTrue(Algoritmos.verificaPropriedade153(153));
    }

    @Test
    void propriedade153NaoSatisfaz() {
        assertFalse(Algoritmos.verificaPropriedade153(154));
    }

    @Test
    void propriedade153ArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.verificaPropriedade153(99));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.verificaPropriedade153(1000));
    }
}
