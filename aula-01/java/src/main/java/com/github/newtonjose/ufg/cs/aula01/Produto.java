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
public class Produto {
    /**
     * Contrutor protegido.
     */
    protected Produto() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static int produto = 0;

    /**
     * Dado dois numeros inteiros a função calcula o produto dos dois
     * usando somatório.
     *
     * @param a Número inteiro natural.
     * @param b Número inteiro natural.
     * @return int Produto dos dois parâmetros.
     * @throws IllegalArgumentException Se os argumentos estiverem fora
     *                                  dos intervalos: a >= 0; b >= 0.
     */
    public static int calculaProdutoInteiros(final int a, final int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Os numeros a e b tem que ser "
                    + "maior ou igual a zero");
        }

        int totalParcelas = a;
        int parcela = b;

        if (b < a) {
            totalParcelas = b;
            parcela = a;
        }

        int i = 1;
        while (i <= totalParcelas) {
            produto = produto + parcela;
            i = i + 1;
        }

        return produto;
    }
}
