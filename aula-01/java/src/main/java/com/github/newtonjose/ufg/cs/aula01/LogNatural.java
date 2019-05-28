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
public final class LogNatural {

    /**
     *
     */
    private static int numerador;

    /**
     *
     */
    private static double logNatural;

    /**
     *
     */
    private static int denominador = 1;

    /**
     * Calcula o logaritmo natural de um dado número usando uma
     * aproximação.
     *
     * @param n Numero inteiro natural.
     * @param k Numero inteiro nartual usado como o fator de aproximação.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     * intervalos: n >= 1; k >= 2.
     * @return double Logaritmo do parâmetro.
     */
    public static double calculaLogNatural(final int n, final int k) {
        if (n < 1 || k < 2) {
            throw new IllegalArgumentException("O numeros tem que ser n >= 1 "
                    + "&& k >= 2");
        }

        numerador = n;
        logNatural = n + 1;

        int i = 2;
            while (i <= k) {
                numerador = numerador * numerador;
                denominador = denominador * i;
                logNatural += (numerador / denominador);
                i += 1;
            }

        return logNatural;
    }
}
