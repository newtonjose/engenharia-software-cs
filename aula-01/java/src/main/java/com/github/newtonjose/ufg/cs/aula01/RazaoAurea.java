package com.github.newtonjose.ufg.cs.aula01;

/**
 * <h1>Classe Logaritmo natural</h1>
 * Classe que implementa o algoritmo que calcula o .
 * <p>Something here</p>
 *
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public class RazaoAurea {
    /**
     * Contrutor protegido.
     */
    protected RazaoAurea() {
        throw new UnsupportedOperationException();
    }

    /**
     * Calcula a razão área através do processo iniciado com dois
     * números inteiros positivos e um valor que determina a precisão.
     *
     * @param x Numero inteiro natural.
     * @param y Numero inteiro natural.
     * @param k Numero inteiro natural usado como fator de prescisão.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     * intervalos: x >= 0; x < y e k > 0.
     * @return double Razão áurea de dois numeros.
     */
    public static double calculaRazaoAurea(final int x, final int y,
                                           final int k) {
        if ((x < 0 || x > y) || k <= 0) {
            throw new IllegalArgumentException("Números deve ser: x >= 0, x < "
                    + "y e k > 0");
        }

        int t;
        int c = y;
        int a = x;

        int i = 1;
        while (i <= k) {
            t = c;
            c += a;
            a = t;
            i = i + 1;
        }

        return c / a;
    }
}
