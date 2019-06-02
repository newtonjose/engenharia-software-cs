package com.github.newtonjose.cs.aula07.estruturas;

/**
 * <h1>Implementa o metodo para encontra a menor temperatura.</h1>
 *
 *<p>Encontrar a menor valor em um vetor de valores recebido como argumento.</p>
 */
public final class MenorTemperatura { //NOPMD
    /**
     * Contrutor privado devido classe ser estatica.
     */
    private MenorTemperatura() {

    }

    /**
     * @param temperatures Vetor de temperaturas.
     * @return int Menor temperatura do vetor passado como paramentro.
     */
    public static int getMenorTemperatura(final int... temperatures) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("nenhuma temperatura foi "
                    + "informada.");
        }

        int menorTemp = temperatures[0];
        int maiorTemp = temperatures[0];

        for (final int tmp : temperatures) {
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
