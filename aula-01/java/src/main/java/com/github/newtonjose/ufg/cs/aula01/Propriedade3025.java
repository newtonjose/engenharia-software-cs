package com.github.newtonjose.ufg.cs.aula01;

/**
 * Classe implementa o algoritmo matemático que verifica se um dado numero
 * segue a propriedade do número 3025.
 *
 * <p>Implementa a Propriedade 3025, tal que 30 + 25 = 55 e o
 * quadrado desta soma resulta no próprio número, 55² = 3025.</p>
 * 
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public final class Propriedade3025 {
    /**
     * Maximo número que a propriedade se aplica.
     */
    private static final int MAX = 9999;

    //private final int DIVISOR = 100;

    /**
     * Verifica se um dado numero é verdadeiro usando a Propriedade 3025.
     *
     * @param n Numero inteiro natural.
     * @return boolean Retorna {true} se o número fornecido como argumento
     * satisfaz a propriedade Propriedade 3025, {false} caso contrário.
     */
    public static boolean verificaPropriedade3025(final int n) {
        if (n < 0 || n > MAX) {
            throw new IllegalArgumentException("Numero fora do range "
                    + "100 <= n <= 999");
        }

        final double i = n / 100;
        final double j = n % 100;
        final double m = i + j;

        return m * m == n;
    }
}
