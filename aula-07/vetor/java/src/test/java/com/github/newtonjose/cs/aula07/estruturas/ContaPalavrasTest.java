package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaPalavrasTest {

    @Test
    void contaPalavraOcorrencias() {
        String[] strings = {"Ola", "Cara", "Mundo", "Mundo"};
        assertEquals("Mundo",
                ContaPalavras.contaPalavraOcorrencias(strings));
    }

    @Test
    void argumentoInvalido() {
        String[] strings = {};

        assertThrows(IllegalArgumentException.class,
                () -> ContaPalavras.contaPalavraOcorrencias(strings));
    }
}