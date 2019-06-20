package com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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


    public ItemNotaFiscal(final Integer qtd, final Double prc,
                          final Integer cdo, final String desc) {
        this.quatidade = qtd;
        this.preco = prc;
        this.codigo = cdo;
        this.descricao = desc;
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

    public int getQuantidade() {
        return this.quatidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getCodigo() {
        return this.codigo;
    }

    private String convertDescricaoToUSASCII(){
        byte[] bytes = this.descricao.getBytes(StandardCharsets.US_ASCII);
        return new String(bytes);
    }

    public byte[] getDescricaoAsByteArray() throws IOException {

        // converter descricao para ASCII
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(baos);

        dos.writeUTF(this.convertDescricaoToUSASCII());

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
}
