package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumeroPiTest {
    @Test
    void calculaNumeroPiAproximado() {
        // FIXME: verifica função no javascript
        assertEquals(3.142841092554028, AlgoritmosUtils.numeroPi(800));
    }

    @Test
    void verificaArgumentosInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.numeroPi(0));
    }
}
