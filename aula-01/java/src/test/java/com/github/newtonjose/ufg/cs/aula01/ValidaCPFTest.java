package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ValidaCPFTest {

    @Test
    void validaCPFCorreto() {
        int[] cpf = new int[]{0, 1, 5, 5, 7, 5, 3, 1, 0, 0, 5};
        assertTrue(AlgoritmosUtils.validaCPF(cpf));

        int[] cpf2 = {7, 4, 8, 3, 3, 8, 4, 3, 8, 7, 0};
        assertTrue(AlgoritmosUtils.validaCPFRegraHorner(cpf2));
    }

    @Test
    void verificaCPFInvalido() {
        int[] cpf = new int[]{3, 4, 5, 6, 1, 3, 3, 9, 4, 4, 5};
        int[] cpf2 = new int[]{3, 4, 5, 6, 1, 3, 3, 9, 4, 4, 6};
        int[] cpf3 = new int[]{3, 4, 5, 6, 1, 3, 3, 9, 4, 2, 6};

        assertFalse(AlgoritmosUtils.validaCPF(cpf));
        assertFalse(AlgoritmosUtils.validaCPF(cpf2));

        // Ambos falso
        assertFalse(AlgoritmosUtils.validaCPFRegraHorner(cpf));

        // digK falso
        assertFalse(AlgoritmosUtils.validaCPFRegraHorner(cpf2));
        // digJ falso
        assertFalse(AlgoritmosUtils.validaCPFRegraHorner(cpf3));
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