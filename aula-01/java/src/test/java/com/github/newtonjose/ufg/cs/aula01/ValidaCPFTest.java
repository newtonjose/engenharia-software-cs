package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ValidaCPFTest {

    @Test
    void validaCPFCorreto() {
        int[] cpf = new int[]{0, 1, 5, 5, 7, 5, 3, 1, 0, 0, 5};
        assertTrue(AlgoritmosUtils.validaCPF(cpf));

        assertFalse(AlgoritmosUtils.validaCPFRegraHorner(cpf));
    }

    @Test
    void verificaCPFInvalido() {
        int[] cpf = new int[]{3, 4, 5, 6, 1, 3, 3, 9, 4, 4, 5};

        assertFalse(AlgoritmosUtils.validaCPF(cpf));

        assertFalse(AlgoritmosUtils.validaCPFRegraHorner(cpf));
    }

    @Test
    void verificaCPFComMaisDigitos() {
        int[] cpf = new int[]{1, 4, 3, 5, 3, 2, 1, 3, 4, 9, 7, 4};
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.validaCPF(cpf));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.validaCPFRegraHorner(cpf));
    }

    @Test
    void verificaCPFComDigitosInvalidos() {
        int[] cpf = new int[]{1, 4, 3, -5, 3, 2, 1, 3, 4, 9, 7};
        int[] cpf2 = new int[]{1, 4, 3, 15, 3, 2, 1, 3, 4, 9, 7};

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.validaCPF(cpf));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.validaCPF(cpf2));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.validaCPFRegraHorner(cpf));
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.validaCPFRegraHorner(cpf2));
    }
}