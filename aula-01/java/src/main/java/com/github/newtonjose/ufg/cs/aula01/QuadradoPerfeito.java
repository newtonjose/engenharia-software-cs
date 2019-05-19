package com.github.newtonjose.ufg.cs.aula01;

/**
 * <h1>Classe QuadradoPerfeito</h1>
 * Classe que implementa o algoritmo que calcula o produto de dois números.
 * <p>Something here</p>
 * 
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public class QuadradoPerfeito {
    /**
     * Contrutor protegido.
     */
    protected QuadradoPerfeito() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static final int CONST = 2;

    /**
     * Verifica se o dado número é um quadrado perefeito, satisfazendo
     * esquação do algoritmo.
     *
     * @param n Número inteiro.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo: n >= 1.
     * @return {boolean} boolean Retorna {true} se o número fornecido é
     * um quadrado perfeito, caso contrário, {false}.
     **/
    public static boolean calculaQuadradoPerfeito(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 1");
        }

        int i = 1;
        int s = 1;

        while (s < n) {
            i += CONST;
            s += i;
        }

        return s == n;
    }
}
