package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testa a classe MenorTemperatura.
 * <p>Cobertura:
 * testaCriaçãoObjetoClasse: Excessão ao criar o objeto protegido.
 * retornaMenorTemperatura: Caso de sucesso, retorna o menor valor.
 * testeParamentroInvalido: Valida a entrada de argumentos inválidos.
 * </p>
 */
class MenorTemperaturaTest {
    @Test
    void testaCriaçãoObjetoClasse() {
        assertThrows(UnsupportedOperationException.class,
                () -> new MenorTemperatura());
    }

    @Test
    void retornaMenorTemperatura() {
        int[] t = new int[]{0, 2, -3, 5};
        assertEquals(-3, MenorTemperatura.getMenorTemperatura(t));
    }

    @Test
    void testeParamentroInvalido() {
        int[] t = new int[]{};
        assertThrows(IllegalArgumentException.class,
                () -> MenorTemperatura.getMenorTemperatura(t)
        );
    }


}