package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SomaPrimeirosNaturaisTest {

    @Test
    void somaNaturaisCorreta() {
        assertEquals(15, Algoritmos.somaNaturais(5));
    }

    @Test
    void somaNaturaisArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.somaNaturais(0));
    }
}
