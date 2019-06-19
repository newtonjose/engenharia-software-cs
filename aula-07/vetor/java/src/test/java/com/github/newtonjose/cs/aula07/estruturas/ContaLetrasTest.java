package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaLetrasTest {

    @Test
    void getQuantidadeLetras() {
        final String strings = "Cheese";
        final Map<Character, Integer> expected = new HashMap<>();

        expected.put('c', 1);
        expected.put('h', 1);
        expected.put('e', 3);
        expected.put('s', 1);

        assertEquals(expected,
                ContaLetrasUtils.contaOcorrenciasLetras(strings));
    }

    @Test
    void argumentoInvalido() {
        final String strings = "";
        assertThrows(IllegalArgumentException.class,
                () -> ContaLetrasUtils.contaOcorrenciasLetras(strings)
        );
    }
}