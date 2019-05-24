package com.github.newtonjose.cs.aula07.estruturas;

/**
 * <h1>Implementa o metodo para encontra a menor temperatura.</h1>
 *
 *<p>Encontrar a menor valor em um vetor de valores recebido como argumento.</p>
 */
public final class MenorTemperatura {
    /**
     * Contrutor protegido,.
     */
    protected MenorTemperatura() {
        throw new UnsupportedOperationException();
    }

    /**
     * @param temps Vetor de temperaturas.
     * @return int Menor temperatura do vetor passado como paramentro.
     */
    public static int getMenorTemperatura(final int... temps) {
        if (temps.length == 0) {
            throw new IllegalArgumentException("nenhuma temperatura foi "
                    + "informada.");
        }

        int menorTemp = temps[0];
        int maiorTemp = temps[0];

        for (final int tmp : temps) {
            if (tmp > maiorTemp) {
                maiorTemp = tmp;
            }

            if (tmp < menorTemp) {
                menorTemp = tmp;
            }
        }

        return menorTemp;
    }
}
