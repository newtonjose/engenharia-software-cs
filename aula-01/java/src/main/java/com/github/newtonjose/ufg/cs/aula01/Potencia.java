package com.github.newtonjose.ufg.cs.aula01;

/**
 * <p>Classe Produto.</p>
 *
 * @author Josenilton Santos
 * @version 1.0
 * @since 2019-03-15
 */
public class Potencia {
    /**
     * Contrutor protegido.
     */
    protected Potencia() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     */
    private static int produtorio = 1;

    /**
     * Calcula a potência de dois numeros usando apenas somas.
     *
     * @param x Numero inteiro natural.
     * @param y Número inteiro natural.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     * intervalos: x >= 0; y >= 0.
     * @return int Potência dos parâmetros.
     */
    public static int calculaPotencia(final int x, final int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Os numeros x e y deverão "
                           + "ser x >=0 e y >=0.");
        }

        int i = 1;
        while (i <= y) {
            produtorio = Produto.calculaProdutoInteiros(produtorio, x);
            i = i + 1;
        }

        return produtorio;
    }
}
