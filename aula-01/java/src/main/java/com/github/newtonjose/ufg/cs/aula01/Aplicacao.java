package com.github.newtonjose.ufg.cs.aula01;

import java.time.LocalDate;

/**
 * Implementação do exercício 04 que retorna dia da semana
 * Programa que retorna dia da semana do dia corrente.
 *
 * <p>Veja detalhes no exercício 4 (aula-01).</p>
 */
public final class Aplicacao {
    /**
     * Construtor privado, retorna error de operação não suportada em caso de
     * uso.
     */
    private Aplicacao() {
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo main que imprime a data do dia na tela.
     * @param args Argumentos de entrada.
     */
    public static void main(final String[] args) {
        System.out.println(LocalDate.now().getDayOfWeek());
    }
}
