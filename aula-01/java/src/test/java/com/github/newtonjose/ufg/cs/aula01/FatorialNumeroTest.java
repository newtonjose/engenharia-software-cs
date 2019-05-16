package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aluno on 16/05/19.
 */
class FatorialNumeroTest {
    @Test
    void criarObjetoDaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new FatorialNumero());
    }

    @Test
    void calculaFatorialCorreto() {
        assertEquals(6, FatorialNumero.calculaFatorial(3));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> FatorialNumero.calculaFatorial(0));
    }
}
