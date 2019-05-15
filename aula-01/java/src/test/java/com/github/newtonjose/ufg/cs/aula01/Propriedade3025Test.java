package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by aluno on 14/05/19.
 */
class Propriedade3025Test {

    @Test
    void propriedade3025Satisfaz() {
        assertTrue(Algoritmos.numeroVerdadeiro(3025));
    }

    @Test
    void propriedade3025NaoSatisfaz() {
        assertFalse(Algoritmos.numeroVerdadeiro(3024));
    }

    @Test
    void propriedade3025ArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.numeroVerdadeiro(-1));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.numeroVerdadeiro(10000));
    }
}
