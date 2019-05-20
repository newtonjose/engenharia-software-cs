package com.github.newtonjose.ufg.cs.aula01;

/**
 * <h1>Produto de Números Inteiros</h1>
 * Classe que implementa o algoritmo que calcula o produto de dois números.
 * <p>Something here</p>
 *
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public class Horner {
    /**
     * Contrutor protegido.
     */
    protected Horner() {
        throw new UnsupportedOperationException();
    }

    /**
     * Avalia um polinônimo por meio de somas, produtos e potências.
     *
     * @param x Número real.
     * @param g Número real.
     * @param a Array de numeros rais.
     * @throws IllegalArgumentException Se o segundo argumento estiver for do
     * intervalo: g > 1.
     * @return int Número real.
     **/
    public static int regraHorner(final int x, final int g, final int[] a) {
        if (g < 1) {
            throw new IllegalArgumentException("g deve ser maior que zero");
        }

        int p = a[g - 1];
        int i = g - 1;
        while (i >= 0) {
            p = p * x + a[i];
            i -= 1;
        }

        return p;
    }

}
