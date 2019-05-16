package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da Class DiaDaSemana com 100% de cobertura.
 */
class DiaDaSemanaTest {

    @Test
    void getDiaDaSemenaCorreto() {
        assertEquals(4, DiaDaSemana.getDiaDaSemana(16, 5, 2019));
    }

    @Test
    void getDiaDaSemanaArgumentoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(0, 1, 1999));

        assertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(32, 1, 1914));

        ssertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 0, 1954));

        ssertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 13, 1877));

        ssertThrows(IllegalArgumentException.class,
                () -> DiaDaSemana.getDiaDaSemana(16, 5, 1000));
    }
}
