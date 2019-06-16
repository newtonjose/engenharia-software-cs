package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomaImparesTest {

    @Test
    void getTotalSomaImpares() {
        int[] vet = new int[]{1, 3, 5};
        assertEquals(3, SomaImparesUtils.getTotalSomaImpares(vet));
    }

    @Test
    void testeParamentroInvalido() {
        int[] t = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> SomaImparesUtils.getTotalSomaImpares(t)
        );
    }
}
