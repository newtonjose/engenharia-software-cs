package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by aluno on 13/06/19.
 */
public final class FromJsonToNotaFiscal {

    private final static Log logger = new Log(FromJsonToNotaFiscal.class);

    // REF.: https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private FromJsonToNotaFiscal() {

    }

    public static NotaFiscal readJsonFileToNotaFiscal() throws IOException {

        logger.info("Leitura do arquivo json.");
        NotaFiscal notaFiscal = objectMapper.readValue(
                new File("./static/nota_fiscal.json"), NotaFiscal.class
        );

        logger.info("Leitura realizada da nota fiscal: "
                + notaFiscal.toString());

        return notaFiscal;
    }
}
