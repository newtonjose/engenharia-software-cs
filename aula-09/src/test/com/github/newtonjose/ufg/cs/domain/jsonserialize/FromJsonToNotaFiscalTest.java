package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FromJsonToNotaFiscalTest {

    @Test
    void readJsonFile() throws IOException {
        NotaFiscal nota = FromJsonToNotaFiscal.readJsonFileToNotaFiscal();

        FromNotaFiscalToBinario nftb = new FromNotaFiscalToBinario();

        byte[] bytes = nftb.notaFiscalToByteArray(nota);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        System.out.println(sb.toString());
    }
}

