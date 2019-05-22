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
public class Fibonacci {
    /**
     * Contrutor protegido.
     */
    protected Fibonacci() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static int fibo = 1;

    /**
     * Calcula o número de Fibonacci sem usar recursividade.
     *
     * @param n Número inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo: n >= 0.
     * @return long Número inteiro natural.
     **/
    public static long fibonacci(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O numero 'n' tem que ser n>=0");
        }

        long t;
        long a = 0;

        if (n == 0 || n == 1) {
            return n;
        }

        int i = 1;
        while (i <= n) {
            t = fibo;
            fibo += a;
            a = t;
            i += 1;
        }

        return fibo;
    }
}
