package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

class ContaLetrasTest {

    @Test
    void getQuantidadeLetras() {
        int[] expec = new int[]{1, 3, 2};
        ContaLetrasUtils.getQuantidadeLetras(
                "abebbe"
        );
    }
}