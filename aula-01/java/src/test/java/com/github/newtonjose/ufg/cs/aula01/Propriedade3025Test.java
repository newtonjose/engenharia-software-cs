package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da Propriedade 3025 com 100% de cobertura.
 */
class Propriedade3025Test {
    @Test
    void criarObjetoDaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new Propriedade3025());
    }

    @Test
    void propriedade3025Satisfaz() {
        assertTrue(Propriedade3025.verificaPropriedade3025(3025));
    }

    @Test
    void propriedade3025NaoSatisfaz() {
        assertFalse(Propriedade3025.verificaPropriedade3025(3024));
    }

    @Test
    void propriedade3025ArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Propriedade3025.verificaPropriedade3025(-1));

        assertThrows(IllegalArgumentException.class,
                () -> Propriedade3025.verificaPropriedade3025(100000));
    }
}
