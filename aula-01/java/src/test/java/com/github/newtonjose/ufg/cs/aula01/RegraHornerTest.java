package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RegraHornerTest {
    @Test
    void regraHornerCorreto() {
        int[] vet = {0,1,2};
        assertEquals(12, Algoritmos.regraHorner(1, 100,
                vet));
    }

    @Test
    void verificaArgumentosInvalidos() {
        int[] poli_array = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.regraHorner(4, 0, poli_array));
    }
}
