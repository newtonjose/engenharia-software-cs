package com.github.newtonjose.ufg.cs.aula01;

/**
 * Created by aluno on 16/05/19.
 */
public class SomaPrimeirosNaturais {

    /**
     * Contrutor protegido.
     */
    protected SomaPrimeirosNaturais() {
        throw new UnsupportedOperationException();
    }

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
