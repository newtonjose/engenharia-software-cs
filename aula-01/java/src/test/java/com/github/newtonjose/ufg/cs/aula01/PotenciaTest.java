package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aluno on 21/05/19.
 */
class PotenciaTest {
    @Test
    void criarObjetoDaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new Potencia());
    }

    @Test
    void calculaPotenciaCorreta() {
        assertEquals(54, Potencia.calculaPotencia(2, 4));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Potencia.calculaPotencia(0, 4));

        assertThrows(IllegalArgumentException.class,
                () -> Potencia.calculaPotencia(2, 0));
    }

}