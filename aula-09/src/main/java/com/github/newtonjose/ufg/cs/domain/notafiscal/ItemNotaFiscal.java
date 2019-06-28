package com.github.newtonjose.ufg.cs.domain.notafiscal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;

/**
 * Created by aluno on 13/06/19.
 */

public class ItemNotaFiscal {
    private final Integer quatidade;
    private final Double preco;
    private final Integer codigo;
    private final String descricao;

    private final StringBuilder stringBuilder = new StringBuilder();
    private static final Integer DESCRICAO_LENGTH = 80;


    /**
     * @param qtd
     * @param prc
     * @param cdo
     * @param desc
     */
    public ItemNotaFiscal(final Integer qtd, final Double prc,
                          final Integer cdo, final String desc) {
        this.quatidade = qtd;
        this.preco = prc;
        this.codigo = cdo;
        this.descricao = desc;
    }

    /**
     * @return
     */
    public int getQuantidade() {
        return this.quatidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getCodigo() {
        return this.codigo;
    }

    private static String removeSinaisDescricao(String descricao) {
        String str = Normalizer.normalize(descricao, Normalizer.Form.NFD);

        return str.replaceAll("\\p{M}", "");
    }

    private static String convertDescricaoToUSASCII(String descricao) {
        String dsc = descricao.replaceAll("ç", "c");

        return removeSinaisDescricao(dsc);
    }

    public byte[] getDescricaoAsByteArray() throws IOException {

        // converter descricao para ASCII
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(baos);

        String dsc = convertDescricaoToUSASCII(this.descricao);
        dos.writeUTF(dsc);

        byte[] auxByteArr = baos.toByteArray();
        if (auxByteArr.length < DESCRICAO_LENGTH) {
            int diff = DESCRICAO_LENGTH - auxByteArr.length;
            for (int i = 0; i < diff; i++) {
                dos.writeUTF("\00");
            }
        }

        dos.flush();

        return Arrays.copyOfRange(baos.toByteArray(), 0, DESCRICAO_LENGTH);
    }

    @Override
    public String toString() {
        stringBuilder.append("Quantidada: ").append(this.quatidade);
        stringBuilder.append(", ");
        stringBuilder.append("Preço: ").append(this.preco).append(", ");
        stringBuilder.append("Codigo: ").append(this.codigo).append(", ");
        stringBuilder.append("Descrição: ").append(this.descricao);

        return stringBuilder.toString();
    }
}
