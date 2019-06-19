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
        assertEquals(7.666666666666666, AlgoritmosUtils.calculaLogNatural(2, 3));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaLogNatural(0, 100));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaLogNatural(3, 1));
    }
}
