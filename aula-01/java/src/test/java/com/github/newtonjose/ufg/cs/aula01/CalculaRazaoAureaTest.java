package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculaRazaoAureaTest {

    @Test
    void casoSucesso() {
        assertEquals(1.6180339887498947,
                AlgoritmosUtils.calculaRazaoAurea(2, 4,1000));
    }

    @Test
    void argumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaRazaoAurea(-1, 2,
                        10));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaRazaoAurea(4, 2,
                        10));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaRazaoAurea(2, 4,
                        0));
    }
}
