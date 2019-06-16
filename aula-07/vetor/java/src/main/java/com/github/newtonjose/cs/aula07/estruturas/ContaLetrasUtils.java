package com.github.newtonjose.cs.aula07.estruturas;

import java.util.Arrays;

/**
 * Classe que implementa a contagem de ocorrencias de cada letra em uma string.
 */
public final class ContaLetrasUtils {

    /**
     * Contrutor privado devido classe ser estatica.
     */
    private ContaLetrasUtils() {

    }

    /**
     * Método que conta a quantidade de ocorrencias de cada letras em uma
     * string.
     * @param msgs String
     * @return long[] Arrays de inteiros.
     */
    public static long[] getQuantidadeLetras(final String... msgs) {
        if (msgs.length == 0) {
            throw new IllegalArgumentException("a string é vazia.");
        }

        final long[] numLetras = new long[]{};
        for (int i = 0; i < msgs.length; i++) {
            final int finalI = i;

            numLetras[i] = Arrays.stream(msgs).filter(
                    m -> m.equals(msgs[finalI])
            ).count();  //TODO: array index out of bounds
        }

        return numLetras;
    }
}
