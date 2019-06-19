package com.github.newtonjose.cs.aula07.estruturas;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
    public static Map<Character, Integer> contaOcorrenciasLetras(
            final String msgs) {

        if (msgs.isEmpty()) {
            throw new IllegalArgumentException("a string é vazia.");
        }

        final String auxMags = msgs.toLowerCase(Locale.US);
        final char[] charArray = auxMags.toCharArray();

        final HashMap<Character, Integer> numLetras = new HashMap<>();
        for (final char ch: charArray) {
            int ocorr = 0;
            for (final char chAux: charArray) {
                if (ch == chAux) {
                    ocorr = ocorr + 1;
                }
            }
            numLetras.put(ch, ocorr);
        }

        return numLetras;
    }
}
