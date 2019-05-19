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
public class MaiorDivisorComum {
    /**
     * Contrutor protegido.
     */
    protected MaiorDivisorComum() {
        throw new UnsupportedOperationException();
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros.
     *
     * @param a Número inteiro natural.
     * @param b Número inteiro natural.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     * intervalos: a >= b e b > 0.
     * @return int Máximo divisor comum de a e b.
     **/
    public static int maiorDivisorComum(int a, int b) {
        if (b > a && b < 0) {
            throw new IllegalArgumentException("Os numeros deverao ser a >= b"
					       + " e b > 0");
        }

        int m;

        while (b != 0) {
            m = a % b;
            a = b;
            b = m;
        }

        return a;
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros
     * sem usar resto da divisão inteira.
     *
     * @param b Número inteiro natural.
     * @param a Array de números inteiros naturais.
     * @throws IllegalArgumentException Se o primeiro argumento estiver
     * fora do intervalo: b > 0.
     * @return int Máximo divisor comum de a e b.
     **/
    public static int maiorDivisorComumSemResto(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Os numero deverao 'b' tem que "
					       + "ser maior que zero!");
        }

        while (b != a) {
            // 'a' sempre sera maior que 'b' pelo if anterior
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }

        return a;
    }

}
