package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Propriedade153Test {

    @Test
    void propriedade153Satisfaz() {
        assertTrue(AlgoritmosUtils.verificaPropriedade153(153));
    }

    @Test
    void propriedade153NaoSatisfaz() {
        assertFalse(AlgoritmosUtils.verificaPropriedade153(154));
    }

    @Test
    void propriedade153ArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.verificaPropriedade153(99));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.verificaPropriedade153(1000));
    }
}
