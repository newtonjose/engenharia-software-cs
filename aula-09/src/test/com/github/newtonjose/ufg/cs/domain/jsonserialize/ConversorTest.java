package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import org.junit.jupiter.api.Test;

class ConversorTest {

    @Test
    void realizaConversao() {
//        ConversorJson.realizaConversao("nota_fiscal.json");

        ConversorJson.realizaConversao("notaError.json");
    }
}