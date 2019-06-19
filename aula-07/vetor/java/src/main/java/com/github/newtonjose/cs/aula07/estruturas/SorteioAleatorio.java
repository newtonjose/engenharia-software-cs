package com.github.newtonjose.cs.aula07.estruturas;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementação da classe com métodos que sorteira aleatoriamente 1000000
 * de inteiros e encontra a ocorrência de cada valor.
 */
public final class SorteioAleatorio {

    /**
     * Constante dos números inteiros a serem sorteados.
     */
    private static final int MAX_SORT = 1000000;

    /**
     * Contrutor privado devido classe ser final.
     */
    private SorteioAleatorio() {

    }

    /**
     * Sorteia 1.000.000 números de inteiros, faz a ordenação pelo número
     * de ocorrencia, e retorna número foi o “mais frequente”, então todos os
     * mais frequentes.
     *
     * @return Map HashMap com os números mais frequentes e suas frequencias.
     */
    public static Map<Integer, Integer> sortear() {

        final Map<Integer, Integer> mapNumero = new ConcurrentHashMap<>();
        final HashMap<Integer, Integer> mapMostFrequent = new HashMap<>();
        final Random rand = new SecureRandom();

        for (int i = 1; i <= MAX_SORT; i++) {
            final int num = rand.nextInt(MAX_SORT);

            mapNumero.merge(num, 1, Integer::sum);
        }

        final Map mapNumeroOrdenado = sortByValues(mapNumero);
        final Integer mostFrenq = (Integer) (
                (Map.Entry) mapNumeroOrdenado.entrySet().toArray()[0]
        ).getValue();

        for (final Object o: mapNumeroOrdenado.entrySet()) {
            final Entry entry = (Entry) o;
            final Integer key = (Integer) entry.getKey();
            final Integer val = (Integer) entry.getValue();

            if (!mostFrenq.equals(val)) {
                break;
            }

            mapMostFrequent.put(key, val);
        }

        return mapMostFrequent;
    }

    /**
     * Ordena um HashMap pelos valores, no cenário, o número de ocorrencia.
     *
     * @param map HashMap a ser ordenado.
     * @param <K> Chave do HashMap.
     * @param <V> Valor do HashMap.
     * @return Map HashMap ordenado.
     */
    private static <K, V extends Comparable<? super V>> Map sortByValues(
            final Map<K, V> map) {

        final List<Entry<K, V>> list = new ArrayList<>(map.entrySet());

        list.sort(Entry.comparingByValue());
        Collections.reverse(list);

        final LinkedHashMap<K, V> result = new LinkedHashMap<>();

        for (final Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
