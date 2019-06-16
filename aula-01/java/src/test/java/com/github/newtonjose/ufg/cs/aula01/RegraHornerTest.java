package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RegraHornerTest {
    @Test
    void regraHornerCorreto() {
        int[] vet = {0,1,2};
        assertEquals(12, AlgoritmosUtils.regraHorner(1, vet));
    }

    @Test
    void verificaArgumentosInvalidos() {
        int[] empty_vet = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.regraHorner(4, empty_vet));
    }
}
