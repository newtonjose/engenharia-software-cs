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
    private static final int RESTO = 10;

    /**
     *
     */
    private static final int ONZE = 11;

    /**
     *
     */
    private static final int DEZ = 10;

    /**
     *
     */
    private static final int NOVE = 9;

    /**
     *
     */
    private static final int OITO = 8;

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamente.
     *
     * @param cpf Array de numeros rais.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     * número: 0 <= n >= 9.
     * @return boolean true ou false Valor lógico.
     **/
    public static boolean validaCPF(final int[] cpf) {
        if (cpf.length != ONZE) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        //TODO: Verificar numeros invalidos no vetor

        int j = 0;
        int k = 0;
        //CONST = 8;
        for (int i = 0; i < NOVE; i++) {
            j += cpf[i];
        }

        for (int i = 1; i < DEZ; i++) {
            k += cpf[i];
        }

        final int dj = (j % ONZE) % RESTO;
        final int dk = (k % ONZE) % RESTO;

        return (dj == cpf[cpf.length - 1]) && (dk == cpf[cpf.length]);
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
        if (d.length != ONZE) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        int p = d[NOVE];
        int s = d[NOVE];
        int o = OITO;
        while (o >= 1) {
            p += d[o];
            s += p;
            o -= 1;
        }

        final int j = (s % ONZE) % RESTO;
        final int k = ((s - p + NOVE * d[DEZ]) % ONZE) % RESTO;

        return (j == d[d.length - 1]) && (k == d[d.length]);
    }
}
