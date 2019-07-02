package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.service.ArquivoService;
import com.github.newtonjose.ufg.cs.utils.Log;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Seguranca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Implementação da classe que implementa o método para a conversão
 * de um arquivo JSON.
 *
 * <p>Classe encapsula a coordenação de ações para que a conversão possa
 * ser realizada de forma assincrona.</p>
 */
public final class ConversorJson {

    /**
     * Variável para o path diretório com as notas fiscais.
     */
    private final String notasFiscaisDir;

    /**
     * Constante com instância de logger.
     */
    private static final Log LOG = new Log(ConversorJson.class);

    /**
     * Construtor que intancia variável com path do diretório das notas.
     *
     * @param nfEnvVar String Path do diretório base.
     */
    public ConversorJson(final String nfEnvVar) {
        notasFiscaisDir = nfEnvVar;
    }

    /**
     * Método que coordena a realização da conversão. Convertendo arquivo json
     * para objeto, converter objeto para formato binário e gera a hash sha-256.
     * Em caso de sucesso, salva o arquivo no diretório dat/ e remove do
     * dirétorio json/. Em caso de erro, a nota fiscal é movida para o diretório
     * error/.
     *
     * @param notaJsonFile String Nome do arquivo a ser convertido.
     * @throws NoSuchAlgorithmException Caso o algoritmo SHA-256 não exista nos
     * pacotes java.
     */
    public void realizaConversao(final String notaJsonFile)
            throws NoSuchAlgorithmException {

        final ArquivoService arqSer = new ArquivoService(this.notasFiscaisDir);

        try {
            LOG.info("Aplicação em operção de conversão da nota "
                    + "fiscal: " + notaJsonFile + ".");

            final String nfPath = this.notasFiscaisDir + "json/" + notaJsonFile;

            final NotaFiscal nota =
                    FromJsonToNotaFiscal.readJsonFileToNotaFiscal(nfPath);

            final FromNotaFiscalToBinario nftb = new FromNotaFiscalToBinario();
            final byte[] data = nftb.notaFiscalToByteArray(nota);

            final Seguranca seg = new Seguranca();
            final byte[] hash = seg.getHashSH256(data);

            arqSer.persisteAsZip(hash, data);

            arqSer.removeJsonNotaFiscal(notaJsonFile);

            LOG.info("Conversão realizada com sucesso!");

        } catch (FileNotFoundException ioe) {
            LOG.info("Error: arquivo " + notaJsonFile
                    + " não encontrado.");
        } catch (IOException ioe) {
            try {
                arqSer.copiaJsonNotaFiscal(notaJsonFile);
            } catch (IOException cioe) {
                LOG.error(cioe.getMessage(), cioe);
            }
            LOG.info("Erro ao realizar a conversão da nota fiscal: "
                    + notaJsonFile);
        } catch (NoSuchAlgorithmException nsae) {
            throw nsae;
        }
    }
}
