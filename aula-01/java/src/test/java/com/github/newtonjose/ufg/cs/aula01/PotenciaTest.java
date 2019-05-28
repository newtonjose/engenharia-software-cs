package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aluno on 21/05/19.
 */
class PotenciaTest {

    @Test
    void calculaPotenciaCorreta() {
        assertEquals(16, Algoritmos.calculaPotencia(2, 4));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaPotencia(0, 4));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaPotencia(2, 0));
    }

}