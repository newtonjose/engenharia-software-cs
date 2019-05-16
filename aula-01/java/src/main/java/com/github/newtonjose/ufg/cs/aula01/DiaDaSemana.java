package com.github.newtonjose.ufg.cs.aula01;

/**
 * Classe que implementação do cálculo do dia da semana.
 *
 * <p>Implementação do algoritmo criado por
 * LARSEN, K. S. Computing the Day of the week,
 * Dr. Dobb´s Journal, april, 1995.
 *
 * @author Josenilton Santos.
 * @version 1.1.
 * @since 2019-03-15.
 */
public class DiaDaSemana {
    /**
     * Contrutor protegido.
     */
    protected DiaDaSemana() {
        throw new UnsupportedOperationException();
    }

    /**
     * Constante que representa o máximo dia de um mês.
     */
    private static final int DIA_MAX = 31;

    /**
     * Constante que representa o máximo dia de um ano.
     */
    private static final int MES_MAX = 12;

    /**
     * Constante que representa o menor ano permitido.
     */
    private static final int ANO_MIN = 1753;

    /**
     * Número de dias na semana.
     */
    private static final int DIAS_SEMANA = 7;

    /**
     * Número auxiliar que representa o número de meses de um ano.
     */
    private static final int NUM_MESES = 13;

    /**
     * Função auxiliar para validar uma data.
     *
     * @param d Dia do mês.
     * @param m Mês do ano.
     * @param a Ano depois de 1753.
     * @return boolean Verdadeiro caso a data seja valida, false caso contrário.
     */
    private static boolean dataInvalida(final int d, final int m, final int a) {
        return ((d < 1 || d > DIA_MAX) || (m < 1 || m > MES_MAX)
                || (a <= ANO_MIN));
    }

    /**
     * A função recebe uma data e calcula qual o dia da semana,
     * 1 - segunda; 2 - terça, 3 ...
     *
     * @param dia Numero natural menor ou igual a 31.
     * @param mes Número natural menor ou igual a 12.
     * @param ano Número natural maior ou igual a 1753.
     * @return int Retorna um número que equivale ao dia da semana da data
     * passada como paramêtro.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     *                                  seguintes intervalos: 1 <= dia <= 31;
     *                                  1 <= mes <= 12 e ano > 1753.
     */
    public static int getDiaDaSemana(final int dia, final int mes,
                                     final int ano) {
        if (dataInvalida(dia, mes, ano)) {
            throw new IllegalArgumentException("O numeros devem ser: "
                    + "1 <= dia <= 31, 1 <= mes <= 12 e ano > 1753!");
        }

        // FINDMORE: como funciona isso em Java
        final boolean janeiroOuFevereiro = (mes == 1) || (mes == 2);

        final int m;
        if (!janeiroOuFevereiro) {
            m = mes;
        } else {
            m = mes + NUM_MESES;
        }

        final int a;
        if (!janeiroOuFevereiro) {
            a = ano;
        } else {
            a = ano - 1;
        }

        final int drDobbsExpr = (((dia + (2 * m) + ((3 * (m + 1)) / 5)
                + a + (a / 4)) - (a / 100)) + (a / 400));

        return drDobbsExpr % DIAS_SEMANA;
    }
}
