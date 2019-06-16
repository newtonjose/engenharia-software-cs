package com.github.newtonjose.cs.aula07.estruturas;

/**
 * Classe que implementa método retorna a quantidade elementos de um array
 * de inteiros.
 */
public final class SomaElementosUtils {

    /**
     * Contrutor privado devido classe ser estatica.
     */
    private SomaElementosUtils() {

    }

    /**
     * Conta a quanidade de um elemento dado em vetor.
     * @param num Número inteiro a ser contado no vetor.
     * @param numbers Array de números inteiros.
     * @return int
     */
    public static int getSomaElementos(final int num, final int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("vetor de numeros vazio.");
        }

        int count = 0;
        for (final int n : numbers) {
            if (n == num) {
                count = count + 1;
            }
        }

        return count;
    }
}
