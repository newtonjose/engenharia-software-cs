package com.github.newtonjose.cs.aula08.encontre.domain;

public final class LinhasTexto {
    private int ocorrencias;
    private int numLinha;
    private int numColuna;
    private String linha;

    public void setLinhaInfos(final int ocor, final int nlin, final int nCol,
                       final String lin) {
        this.ocorrencias = ocor;
        this.numLinha = nlin;
        this.numColuna = nCol;
        this.linha = lin;
    }
}
