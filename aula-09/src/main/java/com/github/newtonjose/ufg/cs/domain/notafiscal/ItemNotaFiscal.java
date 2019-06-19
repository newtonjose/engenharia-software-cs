package com.github.newtonjose.ufg.cs.domain.notafiscal;

/**
 * Created by aluno on 13/06/19.
 */
public class ItemNotaFiscal {
    private Integer quatidade;
    private Double preco;
    private long codigo;
    private String descricao;

    public ItemNotaFiscal(final Integer quatidade, final Double preco,
                          final long codigo, final String descricao) {
        this.quatidade = quatidade;
        this.preco = preco;
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
