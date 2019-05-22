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
public class NumeroPrimo {
    /**
     * Contrutor protegido.
     */
    protected NumeroPrimo() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static int interator = 2;

    /**
     * Verifica se um número é primo quando seus únicos divisores são 1
     * ou ele mesmo.
     *
     * @param n Número inteiro natural.
     * @return boolean Retorna {true} caso n é primo, {false} caso contrario.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     **/
    public static boolean numeroPrimo(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "maior que 1");
        }

        while (interator < n) {
            if (n % interator == 0) {
                return false;
            }

            interator += 1;
        }

        return true;
    }
}
