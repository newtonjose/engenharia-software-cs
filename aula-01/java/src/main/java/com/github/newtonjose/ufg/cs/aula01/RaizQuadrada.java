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
public final class RaizQuadrada {

    /**
     *
     */
    private static double numRaiz = 1;

    /**
     *
     */
    private static final int DIV = 2;

    /**
     * Calcula a raiz quadrada de um número usando o Método Babilônico.
     *
     * @param n Número racional positivo.
     * @param i Numero inteiro nartual usado como o fator de prescisão.
     * @return double Retorna raiz quadrada de n usando a precisão i.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     *                                  intervalos: n > 0.
     **/
    public static double raizQuadrada(final int n, final int i) {
        if (n < 0) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 0");
        }

        int aux = i;
        while (aux >= 0) {
            numRaiz = (numRaiz + n / numRaiz) / DIV;
            aux -= 1;
        }

        return numRaiz;
    }
}
