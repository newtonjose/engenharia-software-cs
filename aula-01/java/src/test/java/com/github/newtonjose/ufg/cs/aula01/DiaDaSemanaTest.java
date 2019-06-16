package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaDaSemanaTest {

    @Test
    void getDiaDaSemenaCorreto() {
        assertEquals(1, AlgoritmosUtils.getDiaDaSemana(4,
                6, 2019));
    }

    @Test
    void getDiaDaSemanaMesUm() {
        assertEquals(0, AlgoritmosUtils.getDiaDaSemana(14,
                1, 2019));
    }

    @Test
    void getDiaDaSemanaMesDois() {
        assertEquals(0, AlgoritmosUtils.getDiaDaSemana(11,
                2, 2019));
    }

    @Test
    void getDiaDaSemanaArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.getDiaDaSemana(0, 1, 1999));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.getDiaDaSemana(32, 1, 1914));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.getDiaDaSemana(16, 0, 1954));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.getDiaDaSemana(16, 13, 1877));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.getDiaDaSemana(16, 5, 1753));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.getDiaDaSemana(16, 5, 1000));
    }
}
