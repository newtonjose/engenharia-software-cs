package com.github.newtonjose.cs.aula08.encontre.domain;

/**
 * Implementação da classe que representa uma linha de um texto e as
 * informações usadas pela classe EncontraPalavra.
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public final class LinhaTexto {

    /**
     * Número de ocorrencias da palavra na linha.
     */
    private int ocorrencias;

    /**
     * Número da linha da primeira ocorrencia.
     */
    private int numLinha;

    /**
     * Número da coluna da primeira ocorrencia.
     */
    private int numColuna;

    /**
     * Linha que está sendo feito a busca das ocorrencias.
     */
    private String linha;

    /**
     * Construtor do objeto LinhaTexto.
     * @param ocor int Número de ocorrencias na linha.
     * @param nlin int Número da linha da primeira ocorrencia.
     * @param nCol int Número da coluna da primeira ocorrencia.
     * @param lin String Linha com as informações buscadas.
     */
    public void setLinhaInfos(final int ocor, final int nlin, final int nCol,
                       final String lin) {
        this.ocorrencias = ocor;
        this.numLinha = nlin;
        this.numColuna = nCol;
        this.linha = lin;
    }

    /**
     * Método para ter acesso ao número da coluna de uma linha  do arquivo.
     *
     * @return int Número da coluna.
     */
    public int getNumColuna() {
        return numColuna;
    }

    /**
     * Método para ter acesso ao número da linha de uma linha do arquivo.
     *
     * @return int Número da coluna.
     */
    public int getNumLinha() {
        return numLinha;
    }

    /**
     * Método para retornar as ocoreencias de uma palavra em uma linha
     * arquivo.
     *
     * @return int
     */
    public int getOcorrencias() {
        return ocorrencias;
    }

    /**
     * Linha do arquivo onde existe ocorrencias da palavra que se busca.
     *
     * @return String
     */
    public String getLinha() {
        return linha;
    }
}
