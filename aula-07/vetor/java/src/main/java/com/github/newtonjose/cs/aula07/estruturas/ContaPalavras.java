package com.github.newtonjose.cs.aula07.estruturas;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Implementa o método que encontra ocorrencias de uma palavra.
 */
public final class ContaPalavras {

    /**
     * Contrutor privado, pois a classe é final.
     */
    private ContaPalavras() {

    }

    /**
     * Método que encontra a palavra com mais orcorrencia numa array de string.
     *
     * @param msgs Arrays de palavras.
     * @return String Palavra com mais ocorrência no Arrays.
     */
    public static String contaPalavraOcorrencias(final String... msgs) {
        if (msgs.length == 0) {
            throw new IllegalArgumentException("a string é vazia.");
        }

        final HashMap<String, Integer> mapPalavras = new HashMap<>();

        for (final String palavra: msgs) {
            final int ocorrencia = (int) Arrays.stream(msgs).filter(
                    m -> m.equals(palavra)).count();

            mapPalavras.put(palavra, ocorrencia);
        }

        final Map map = sortByValue(mapPalavras);
        final Object[] shorted = map.keySet().toArray();

        return (String) shorted[shorted.length - 1];
    }

    /**
     * Ordena um HashMap pelos valores, no cenário, o número de ocorrencia.
     *
     * @param map HashMap a ser ordenado.
     * @param <K> Chave do HashMap.
     * @param <V> Valor do HashMap.
     * @return Map HashMap ordenado.
     */
    private static <K, V extends Comparable<? super V>> Map sortByValue(
            final Map<K, V> map) {

        final List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        final LinkedHashMap<K, V> result = new LinkedHashMap<>();

        for (final Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}

/**
 * Ref: https://stackoverflow.com/a/2581754
 */
