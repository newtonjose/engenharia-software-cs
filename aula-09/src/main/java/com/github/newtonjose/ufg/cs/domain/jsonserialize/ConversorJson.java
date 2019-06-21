package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.service.ArquivoService;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Log;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Seguranca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by aluno on 13/06/19.
 */
public final class ConversorJson {

    private static final Log LOGGER = new Log(ConversorJson.class);

    private ConversorJson() {
    }

    // recebe a sinalização de que o diretório de entrada recebe a criação
    // de um arquivo.
    public static void realizaConversao(final String notaJsonFile)
            throws NoSuchAlgorithmException {

        final ArquivoService arqSer = new ArquivoService();

        try {
            final NotaFiscal nota = FromJsonToNotaFiscal.
                    readJsonFileToNotaFiscal(notaJsonFile);

            final FromNotaFiscalToBinario nftb = new FromNotaFiscalToBinario();
            final byte[] data = nftb.notaFiscalToByteArray(nota);

            final Seguranca seg = new Seguranca();
            final byte[] hash = seg.getHashSH256(data);

            arqSer.persisteAsZip(hash, data);

            //Remover nota da pasta json
            arqSer.removeJsonNotaFiscal(notaJsonFile);
        } catch (FileNotFoundException ioe) {
            LOGGER.info("Error: arquivo " + notaJsonFile
                    + " não encontrado.");
        } catch (IOException ioe) {
            try {
                arqSer.copiaJsonNotaFiscal(notaJsonFile);
            } catch (IOException cioe) {
                // error provável é que não existe o arquivo.
            }
            LOGGER.info("Erro ao realizar a conversão da nota fiscal: "
                    + notaJsonFile);
        } catch (NoSuchAlgorithmException nsae) {
            throw nsae;
        }
    }
}
