package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculaRazaoAureaTest {

    //FIXME: error nesse test
    @Test
    void casoSucesso() {
        assertEquals(2, Algoritmos.calculaRazaoAurea(4, 2,
        10));
    }

    @Test
    void argumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaRazaoAurea(-1, 2,
                        10));
    }
}
