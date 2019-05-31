package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by aluno on 30/05/19.
 */
public class RegraHornerTest {
    @Test
    void regraHornerCorreto() {
//        assertEquals(1, Algoritmos.calculaLogNatural(10, 100));
    }

    @Test
    void verificaArgumentosInvalidos() {
        int[] poli_array = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.regraHorner(4, 0, poli_array));
    }
}
