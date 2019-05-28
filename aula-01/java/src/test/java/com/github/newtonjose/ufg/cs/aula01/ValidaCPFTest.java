package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aluno on 21/05/19.
 */
class ValidaCPFTest {

    @Test
    void validaCPFCorreto() {
        int [] cpf = new int[]{1, 4, 3, 5, 3, 2, 1, 3, 4, 9, 7};
        assertFalse(Algoritmos.validaCPF(cpf));

        assertFalse(Algoritmos.validaCPFRegraHorner(cpf));
    }

    @Test
    void verificaCPFComMaisDigitos() {
        int [] cpf = new int[]{1, 4, 3, 5, 3, 2, 1, 3, 4, 9, 7, 4};
        assertThrows(IllegalArgumentException.class,
                () ->Algoritmos.validaCPF(cpf));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.validaCPFRegraHorner(cpf));
    }

//    @Test
//    void verificaCPFComDigitosInvalidos() {
//        int [] cpf = new int[]{23, 4, 19, 5, 3, 2, -1, 3, 4, -10, 7};
//        assertThrows(IllegalArgumentException.class,
//                () ->ValidaCPF.validaCPF(cpf));
//
//        assertThrows(IllegalArgumentException.class,
//                () -> ValidaCPF.validaCPFRegraHorner(cpf));
//    }
}