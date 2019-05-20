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
public class ValidaCPF {
    /**
     * Contrutor protegido.
     */
    protected ValidaCPF() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static final int resto = 10;

    /**
     *
     */
    private static int constante = 8;

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamente.
     *
     * @param d Array de numeros rais.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     * número: 0 <= n >= 9.
     * @return boolean true ou false Valor lógico.
     **/
    public static boolean validaCPF(final int[] d) {
        if (d.length != 11) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        int j = 0;
        int k = 0;
        for (int i = 0; i < 9; i++) {
            j += d[i];
        }

        for (int i = 1; i < 10; i++) {
            k += d[i];
        }

        final int dj = (j % 11) % resto;
        final int dk = (k % 11) % resto;

        return (dj == d[d.length - 1]) && (dk == d[d.length]);
    }

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamenten usando o Método de Horner.
     *
     * @param d Array de numeros rais.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     * número: 0 <= n >= 9.
     * @return boolean true ou false Valor lógico.
     **/
    public static boolean validaCPFRegraHorner(final int[] d) {
        if (d.length != 11) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        int p = d[9];
        int s = d[9];

        while (constante >= 1) {
            p += d[constante];
            s += p;
            constante -= 1;
        }

        final int j = (s % 11) % resto;
        final int k = ((s - p + 9 * d[10]) % 11) % resto;

        return (j == d[d.length - 1]) && (k == d[d.length]);
    }
}
