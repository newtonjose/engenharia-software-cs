package com.github.newtonjose.ufg.cs.aula01;

/**
 * Classe implementa o algoritmo matemático para soma dos n primeiros naturais
 * dado um número.
 *
 * <p>Implementa um somatório para os primeiros n naturais n * (n + 1) / 2.</p>
 *
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public final class SomaPrimeirosNaturais {

    /**
     * Dado um número natural, soma os todos os primeiros naturais
     * ate o dado número.
     *
     * @param n Número inteiro natural.
     * @return int Número inteiro natural.
     *
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    public static int somaNaturais(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "n >= 1.");
        }

        int i = 2;
        int soma = 1;
        while (i <= n) {
            soma += i;
            i += 1;
        }

        return soma;
    }
}
