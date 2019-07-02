package com.github.newtonjose.ufg.cs.domain.jsonserialize;


import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.newtonjose.ufg.cs.domain.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.utils.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Implementação da classe que converte Json para objeto.
 *
 * <p>Classe com método que realiza a leitura do arquivo json e converte em
 * objeto NotaFiscal.</p>
 */
public final class FromJsonToNotaFiscal {

    /**
     * Constante com instância de logger.
     */
    private static final Log LOG = new Log(FromJsonToNotaFiscal.class);

    /**
     * Intância da classe ObjectMapper da lib Jackson.
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Construtor privado pois a classe não é instanciável.
     */
    private FromJsonToNotaFiscal() {
    }

    /**
     * Método estático que realiza a leitura do arquivo json para o objeto
     * Nota Fiscal realizando validação básica.
     *
     * @param filePath String Path do arquivo json.
     * @return NotaFiscal Objeto com todos os campos do json.
     * @throws IOException Caso tenha erro na leitura do arquivo json.
     */
    public static NotaFiscal readJsonFileToNotaFiscal(final String filePath)
            throws IOException {


        SimpleModule module = new SimpleModule(
                "NotaFiscalDeserializer", new Version(1,
                0, 0, null, null,
                null)
        );

        module.addDeserializer(NotaFiscal.class, new NotaFiscalDeserializer());
        objectMapper.registerModule(module);

        NotaFiscal notaFiscal;
        try {
            objectMapper.readTree(new File(filePath));
            notaFiscal = objectMapper.readValue(
                    new File(filePath), NotaFiscal.class
            );
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
            throw ioe;
        }

        return notaFiscal;
    }
}
