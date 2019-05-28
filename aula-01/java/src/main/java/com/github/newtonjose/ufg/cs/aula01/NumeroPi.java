package com.github.newtonjose.ufg.cs.aula01;

/**
 * <h1>Classe Numero Pi</h1>
 * Classe que implementa o algoritmo que calcula o produto de dois números.
 * <p>Something here</p>
 *
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public final class NumeroPi {
    /**
     * Contrutor protegido.
     */
    private NumeroPi() {}

    /**
     *
     */
    private static double numPi = 0;

    /**
     *
     */
    private static final int MULT = 4;
    /**
     * Retorna o valor de Pi aproximado pelo um dado número.
     *
     * @param n Numero inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo: n >= 1.
     * @return double Valor do número Pi aproximado.
     */
    public static double numeroPi(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero n tem que ser n >= 1");
        }

        int i = 1;
        int s = -1;
        int d = -1;

        while (i <= n) {
            d = d + 2;
            s = -1 * s;
            numPi = numPi + (s * MULT) / d;
            i = i + 1;
        }

        return numPi;
    }
}
