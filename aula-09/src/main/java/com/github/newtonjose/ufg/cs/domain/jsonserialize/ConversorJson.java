package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.service.ArquivoService;
import com.github.newtonjose.ufg.cs.utils.Log;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Seguranca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by aluno on 13/06/19.
 */
public final class ConversorJson {

    private String notasFiscaisDir;

    private static final Log LOGGER = new Log(ConversorJson.class);

    public ConversorJson(final String nfEnvVar) {
        notasFiscaisDir = nfEnvVar;
    }

    // recebe a sinalização de que o diretório de entrada recebe a criação
    // de um arquivo.
    public void realizaConversao(final String notaJsonFile)
            throws NoSuchAlgorithmException {

        //TODO: Data inclompleta sendo serelializada
        //TODO: Criar pacote .jar

        final ArquivoService arqSer = new ArquivoService(this.notasFiscaisDir);

        try {
            LOGGER.info("Aplicação em operção de conversão da nota "
                    + "fiscal: " + notaJsonFile + ".");

            final String nfPath = this.notasFiscaisDir + "json/" + notaJsonFile;

            final NotaFiscal nota =
                    FromJsonToNotaFiscal.readJsonFileToNotaFiscal(nfPath);

            final FromNotaFiscalToBinario nftb = new FromNotaFiscalToBinario();
            final byte[] data = nftb.notaFiscalToByteArray(nota);

            final Seguranca seg = new Seguranca();
            final byte[] hash = seg.getHashSH256(data);

            arqSer.persisteAsZip(hash, data);

            //Remover nota da pasta json
            arqSer.removeJsonNotaFiscal(notaJsonFile);

            LOGGER.info("Conversão realizada com sucesso!");

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
