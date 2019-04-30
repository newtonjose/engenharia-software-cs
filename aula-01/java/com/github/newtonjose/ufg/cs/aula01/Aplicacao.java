package com.github.newtonjose.ufg.cs.aula01;

import java.time.LocalDate;

/**
 * Programa que retorna dia da semana do dia corrente.
 *
 * <p>Veja detalhes no exercício 4 (aula-01).</p>
 */
public class Aplicacao {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().getDayOfWeek());
    }
}
