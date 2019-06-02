package com.github.newtonjose.cs.aula07.estruturas;

import java.util.Arrays;

public final class ContaLetras { //NOPMD

    /**
     * Contrutor privado devido classe ser estatica.
     */
    private ContaLetras() {

    }

    public static long[] getQuantidadeLetras(final String... msgs) {
        if (msgs.length == 0) {
            throw new IllegalArgumentException("a string é vazia.");
        }

        final long[] numLetras = new long[]{};
        for (int i = 0; i < msgs.length; i++) {
            int finalI = i;
            numLetras[i] = Arrays.stream(msgs).filter(m -> m.equals(msgs[finalI])).count();
        }

        return numLetras;
    }
}
