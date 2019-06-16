package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CrivoEratostenesTest {

    @Test
    void calculaCrivoCorreto() {

        Map<Integer, Boolean> map = AlgoritmosUtils.sieveOfEratosthenes(
                6);
        assertTrue(map.get(5));
        assertFalse(map.get(4));
    }

    @Test
    void verificaArgumentosInvalidos() {

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.sieveOfEratosthenes(
                        0));

    }
}
