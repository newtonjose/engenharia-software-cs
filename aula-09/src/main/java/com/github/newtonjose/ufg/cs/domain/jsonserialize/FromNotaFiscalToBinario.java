package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.notafiscal.ItemNotaFiscal;
import com.github.newtonjose.ufg.cs.domain.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.utils.Log;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Implementação da classe que converte objeto em formato binario.
 *
 * <p>Classe com método que realiza a conversão do objeto NotaFiscal em
 * array de bytes.</p>
 */
public class FromNotaFiscalToBinario {

    /**
     * Instância da classe  que realiza a conversão.
     */
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    /**
     * Instância com padrão de bytes para cada tipo de dado.
     */
    private final DataOutputStream dos = new DataOutputStream(baos);

    /**
     * Constante com instância de logger.
     */
    private static final Log LOG = new Log(FromNotaFiscalToBinario.class);

    /**
     * Método estático de conversão de um objeto NotaFiscal para um array de
     * bytes usando a ByteArrayOutputStream e DataOutputStream.
     *
     * @param notaFiscal NotaFiscal Objeto a ser convertido.
     * @return byte[] Array de byte bytes dos atributos do objeto nota fiscal.
     * @throws IOException Caso exita erro na conversão dos tipos.
     */
    public byte[] notaFiscalToByteArray(final NotaFiscal notaFiscal)
            throws IOException {

        LOG.info("Convertendo dodos da Nota Fiscal em bytes.");

        try {
            dos.writeInt(notaFiscal.getDataAsInt());
            dos.writeDouble(notaFiscal.getTotal());

            for (final ItemNotaFiscal item: notaFiscal.getItens()) {
                dos.writeInt(item.getCodigo());
                dos.write(item.getDescricaoAsByteArray());
                dos.writeInt(item.getQuantidade());
                dos.writeDouble(item.getPreco());
            }

            dos.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }

        final byte[] byteArr = baos.toByteArray();

        LOG.info("Dodos convertidos: " + byteArr.length + " bytes.");

        return byteArr;
    }
}
