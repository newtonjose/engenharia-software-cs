package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.ItemNotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Log;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;


/**
 * Created by aluno on 13/06/19.
 */
public class FromNotaFiscalToBinario {

    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    private final DataOutputStream dos = new DataOutputStream(baos);

    private final static Log logger = new Log(FromNotaFiscalToBinario.class);

    public byte[] notaFiscalToByteArray(final NotaFiscal notaFiscal)
            throws IOException {

        logger.info("Convertendo dodos da Nota Fiscal em bytes.");

        // convertendo data como inteiro em 4 bytes
        dos.writeInt(notaFiscal.getDataAsInt());
        dos.writeDouble(notaFiscal.getTotal());

        for (ItemNotaFiscal item: notaFiscal.getItens()) {
            dos.writeInt(item.getQuantidade());
            dos.writeDouble(item.getPreco());
            dos.writeInt(item.getCodigo());
            dos.write(item.getDescricaoAsByteArray());
        }

        logger.info("Data em bytes: " + Arrays.toString(baos.toByteArray()));

        dos.flush();
        // retorna o array de bytes dos atributos do objeto nota fiscal
        return baos.toByteArray();
    }
}
