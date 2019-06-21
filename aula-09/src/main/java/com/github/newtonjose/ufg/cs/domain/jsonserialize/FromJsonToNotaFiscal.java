package com.github.newtonjose.ufg.cs.domain.jsonserialize;


import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by aluno on 13/06/19.
 */
public final class FromJsonToNotaFiscal {

    private static final Log logger = new Log(FromJsonToNotaFiscal.class);
    private static final String NOTAS_FISCAIS = "./static/";

    // REF.: https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
    private static ObjectMapper objectMapper = new ObjectMapper();

    private FromJsonToNotaFiscal() {

    }

    public static NotaFiscal readJsonFileToNotaFiscal(final String fileName)
            throws IOException {


        SimpleModule module = new SimpleModule(
                "NotaFiscalDeserializer", new Version(1,
                0, 0, null, null,
                null)
        );

        module.addDeserializer(NotaFiscal.class, new NotaFiscalDeserializer());
        objectMapper.registerModule(module);

        final String path = NOTAS_FISCAIS + "json/" + fileName;
        NotaFiscal notaFiscal;
        try {
            // Validação do arquivo json
            objectMapper.readTree(new File(path));
            notaFiscal = objectMapper.readValue(
                    new File(path), NotaFiscal.class
            );
        } catch (IOException ioe) {
            logger.error(ioe);
            throw ioe;
        }

        return notaFiscal;
    }
}
