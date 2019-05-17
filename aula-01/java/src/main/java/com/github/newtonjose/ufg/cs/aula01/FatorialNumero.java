package com.github.newtonjose.ufg.cs.aula01;

/**
 * Created by aluno on 16/05/19.
 */
class FatorialNumero {
    /**
     * Contrutor protegido.
     */
    protected FatorialNumero() {
        throw new UnsupportedOperationException();
    }

    /**
     * Menor fatorial de um número, no caso de n = 1.
     */
    private static long fatorial = 1;

    /**
     * Calcula o fatorial de um dado numero natural sem usar
     * recursividade.
     *
     * @param n Número inteiro natural.
     * @return int Fatorial do número n.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    static long calculaFatorial(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "n >= 1.");
        }

        int i = 2;
        while (i <= n) {
            fatorial = fatorial * i;
            i = i + 1;
        }

        return fatorial;
    }
}
