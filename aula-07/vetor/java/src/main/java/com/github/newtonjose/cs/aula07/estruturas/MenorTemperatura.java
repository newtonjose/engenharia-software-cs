package com.github.newtonjose.cs.aula07.estruturas;

/**
 * Created by aluno on 21/05/19.
 */
public final class MenorTemperatura {
    /**
     * Contrutor protegido.
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
