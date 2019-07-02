package com.github.newtonjose.ufg.cs.domain.notafiscal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;

/**
 * Implementação da classe que representa um item de uma nota fiscal.
 *
 * <p>Classe com os parâmetros e métodos para representar item de uma nota
 * fiscal e realizar acesso aos campos.</p>
 */
public class ItemNotaFiscal {
    /**
     * Campo que representa a quantidade do item em uma nota fiscal.
     */
    private final Integer quatidade;

    /**
     * Campo que representa o preço do item na nota fiscal.
     */
    private final Double preco;

    /**
     * Campo que representa o código do item na nota fiscal.
     */
    private final Integer codigo;

    /**
     * Campo que representa a descrição do item nota fiscal.
     */
    private final String descricao;

    /**
     * Constante que representa o tamanho máximo de caracteres de uma descrição.
     */
    private static final Integer DESCRICAO_LENGTH = 80;


    /**
     * Construtor de um item da nota fiscal.
     *
     * @param qtd Interger Quantidade do item.
     * @param prc Double Preço do item.
     * @param cdo Integer Código do item.
     * @param desc String Descrição do item.
     */
    public ItemNotaFiscal(final Integer qtd, final Double prc,
                          final Integer cdo, final String desc) {
        this.quatidade = qtd;
        this.preco = prc;
        this.codigo = cdo;
        this.descricao = desc;
    }

    /**
     * Método de acesso a quantidade do item.
     *
     * @return int Quantidade.
     */
    public int getQuantidade() {
        return this.quatidade;
    }

    /**
     * Método de acesso ao preço do item.
     * @return double Preço.
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Método de acesso ao código do item.
     * @return int Código.
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Método de remoção dos caracteris especiais.
     *
     * @param descricao String Descrição do item.
     * @return String Descrição em formato ASCII.
     */
    private static String convertDescricaoToUSASCII(final String descricao) {
        final String dsc = descricao.replaceAll("ç", "c");

        final String str = Normalizer.normalize(dsc, Normalizer.Form.NFD);
        return str.replaceAll("\\p{M}", "");
    }

    /**
     * Método para a conversão da descrição em array de bytes. Usando o tamanho
     * fixo 80 caracteres.
     *
     * @return byte[] Array de byte com tamanho definido.
     * @throws IOException Caso exita erro na conversão do tipo para bytes.
     */
    public byte[] getDescricaoAsByteArray() throws IOException {

        // converter descricao para ASCII
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final DataOutputStream dos = new DataOutputStream(baos);

        final String dsc = convertDescricaoToUSASCII(this.descricao);
        dos.writeUTF(dsc);

        final byte[] auxByteArr = baos.toByteArray();
        if (auxByteArr.length < DESCRICAO_LENGTH) {
            final int diff = DESCRICAO_LENGTH - auxByteArr.length;
            for (int i = 0; i < diff; i++) {
                dos.writeUTF("\00");
            }
        }

        dos.flush();

        return Arrays.copyOfRange(baos.toByteArray(), 0, DESCRICAO_LENGTH);
    }
}
