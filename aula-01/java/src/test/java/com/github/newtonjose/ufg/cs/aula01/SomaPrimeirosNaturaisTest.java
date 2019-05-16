package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aluno on 16/05/19.
 */
class SomaPrimeirosNaturaisTest {
    @Test
    void criarObjetoDaClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new SomaPrimeirosNaturais());
    }

    @Test
    void somaNaturaisCorreta() {
        assertEquals(15, SomaPrimeirosNaturais.somaNaturais(5));
    }

    @Test
    void somaNaturaisArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> SomaPrimeirosNaturais.somaNaturais(0));
    }
}
