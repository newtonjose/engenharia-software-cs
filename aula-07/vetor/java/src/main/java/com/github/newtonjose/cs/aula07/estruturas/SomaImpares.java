package com.github.newtonjose.cs.aula07.estruturas;

/**
 * <h1>Implementa a soma de numeros impares</h1>
 *
 * <p>Retornar a soma de números ímpares contidos em um vetor de inteiros.</p>
 */
public final class SomaImpares {
    /**
     * Contrutor protegido para cobertura de teste.
     */
    protected SomaImpares () {
        throw new UnsupportedOperationException();
    }

    /**
     * @param nums Vetor de numeros naturais.
     * @return int Soma de todos os impares do vetor passado como parametro.
     */
    public static int getTotalSomaImpares(final int... nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("vetor de numeros vazio.");
        }

        for (final int n : nums) {
            if (n % 2 == 1) {

            }
        }
        return 0;
    }
}
