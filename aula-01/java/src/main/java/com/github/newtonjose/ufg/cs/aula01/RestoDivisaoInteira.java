package com.github.newtonjose.ufg.cs.aula01;

/**
 *  Classe implementa o algoritmo matemático para o calculo do resto
 *  divisão inteira.
 *
 *  <p>Implementação de resto da divisão inteira, por exemplo, resto da
 *  divisão de 3 por 8 é 3.</p>
 *
 * @author Josenilton Santos.
 * @version 1.1.
 * @since 2019-03-15.
 */
public class RestoDivisaoInteira {
    /**
     * Contrutor protegido.
     */
    protected RestoDivisaoInteira() {
        throw new UnsupportedOperationException();
    }

    /**
     * Dado dois numeros, está função encontra o resto da divisão de x por y.
     *
     * @param x Numero racional.
     * @param y Número racional.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     *                                  intervalos: y >= 0; x > 0.
     * @return int Retorna o resto da duvisão inteira.
     */
    public static int calculaRestoDivisao(final int x, final int y) {
        if (x < 0 || y <= 0) {
            throw new IllegalArgumentException("O numeros devem ser y >= 0 && "
                    + "x > 0.");
        }

        int i = y;
        int resto = x;
        while (i <= resto) {
            resto -= i;
        }

        return resto;
    }
}
