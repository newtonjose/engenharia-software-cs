package com.github.newtonjose.cs.aula07.estruturas;

import java.util.Arrays;

/**
 * Implementa a soma de numeros impares.
 *
 * <p>Retornar a soma de números ímpares contidos em um vetor de inteiros.</p>
 */
public final class SomaImparesUtils {

    /**
     * Contrutor privado devido classe ser estatica.
     */
    private SomaImparesUtils() {

    }

    /**
     * @param numbers Vetor de numeros naturais.
     * @return int Soma de todos os impares do vetor passado como parametro.
     */
    public static long getTotalSomaImpares(final int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("vetor de numeros vazio.");
        }

        return Arrays.stream(numbers).filter(v -> v % 2 == 1).count(); //NOPMD
    }
}
