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
public class CrivoErastostenes {
    /**
     * Contrutor protegido.
     */
    protected CrivoErastostenes() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static int multiplo;

    /**
     * Verifica se um dado número é primo usando o método
     * Crivo de Erastóstenes.
     *
     * @param n Número inteiro natural.
     * @param a Array de inteiros, com valores iguais a zero.
     * @throws IllegalArgumentException Se o argumento estiver
     * for do intervalo: n > 1.
     * @throws IllegalArgumentException Se o argumento array tiver valor
     * diferente de zero.
     * @return boolean Retorna {true} caso o valor da n possição do array
     * seja diferente de 1, {false} caso contrario.
     **/
    public static boolean calculaCrivoErastostenes(final int[] a, final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "maior que 1");
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                throw new IllegalArgumentException("Existe valores em a, onde "
                        + "nao sao iguais a zero");
            }
        }

        final double limite = Math.sqrt(n); //FIXME

        int i = 2;
        while (i <= limite) {
            if (a[i] == 0) {
                multiplo = i + 1;

                while (multiplo <= n) {
                    a[multiplo] = 1;
                    multiplo += i;
                }
            }
            i += 1;
        }

        return a[n] != 1;
    }
}
