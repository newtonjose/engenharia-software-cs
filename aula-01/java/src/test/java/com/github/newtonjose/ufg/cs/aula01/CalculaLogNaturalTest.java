package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by aluno on 30/05/19.
 */
public class CalculaLogNaturalTest {
    @Test
    void calculaLogNaturalCorreto() {
//        assertEquals(1, Algoritmos.calculaLogNatural(10, 100));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaLogNatural(0, 100));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaLogNatural(3, 1));
    }
}
