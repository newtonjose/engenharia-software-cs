package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da Class Propriedade153 com 100% de cobertura.
 */
class Propriedade153Test {

    @Test
    void propriedade153Satisfaz() {
        assertTrue(Propriedade153.verificaPropriedade153(153));
    }

    @Test
    void propriedade153NaoSatisfaz() {
        assertFalse(Propriedade153.verificaPropriedade153(154));
    }

    @Test
    void propriedade153ArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Propriedade153.verificaPropriedade153(99));

        assertThrows(IllegalArgumentException.class,
                () -> Propriedade153.verificaPropriedade153(1000));
    }
}
