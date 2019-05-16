package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste da Class DiaDaSemana com 100% de cobertura.
 */
class DiaDaSemanaTest {

    @Test
    void getDiaDaSemenaCorreto() {
        assertEquals(1, DiaDaSemana.getDiaDaSemana(14,
                5, 2019));
    }

    @Test
    void getDiaDaSemanaMesUm() {
        assertEquals(3, DiaDaSemana.getDiaDaSemana(14,
                1, 2019));
    }

    @Test
    void getDiaDaSemanaArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(0, 1, 1999));

        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(32, 1, 1914));

        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 0, 1954));

        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 13, 1877));

        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 5, 1753));

        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 5, 1000));
    }

    @Test
    void criarObjetodaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new DiaDaSemana());
    }
}
