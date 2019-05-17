package com.github.newtonjose.ufg.cs.aula01;

/**
 * <h1>Propriedade 153.</h1>
 * Classe implementa o algoritmo matemático que verifica se um dado numero
 * segue a propriedade do número 153, ou seja, soma dos cubos dos dígitos do
 * número 153 resulta em 153, 1³ + 5³ + 3³ = 153.
 * 
 * @author Josenilton Santos
 * @version 1.1
 * @since 2019-03-15
 */
public final class Propriedade153 {
    /**
     * Contrutor protegido.
     */
    protected Propriedade153() {
        throw new UnsupportedOperationException();
    }

    /**
     * Maior valor válido para propriedade 153.
     */
    private static final int MAX = 999;
    
    /**
     * Menor valor válido para propriedade 153.
     */
    private static final int MIN = 100;

    /**
     * Verifica se a soma dos cubos dos digitos de um dado número é
     * igual ao número dado.
     *
     * @param n Numero inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo 100 a 999.
     * @return boolean Retorna {true} se satisfazer a propriedade 153
     * e {false} caso contrário.
     */
    public static boolean verificaPropriedade153(final int n) {
        if (n < MIN || n > MAX) {
            throw new IllegalArgumentException("O número não está no "
                + "intervalor: 100 <= n <= 999");
        }

        final int r = n % 100;
        final int c = n / 100;
        final int d = r / 10;
        final int u = r % 10;

        return (c * c * c + d * d * d + u * u * u) == n;
    }
}
