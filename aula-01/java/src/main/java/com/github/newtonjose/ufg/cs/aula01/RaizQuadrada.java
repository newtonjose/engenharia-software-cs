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
public class RaizQuadrada {
    /**
     * Contrutor protegido.
     */
    protected RaizQuadrada() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static doble numRaiz = 1;

    /**
     *
     */
    private static final int DIV = 2;

    /**
     * Calcula a raiz quadrada de um número usando o Método Babilônico.
     *
     * @param n Número racional positivo.
     * @param i Numero inteiro nartual usado como o fator de prescisão.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     * intervalos: n > 0.
     * @return double Retorna raiz quadrada de n usando a precisão i.
     **/
    public static double raizQuadrada(final int n, int i) {
        if (n < 0) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 0");
        }

        while (i >= 0) {
            numRaiz = (numRaiz + n / numRaiz) / DIV;
            i -= 1;
        }

        return numRaiz;
    }
}

    
