package com.github.newtonjose.cs.aula08.encontre.domain;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 * Implementação da classe que encontra as ocorrencias de uma sequência de
 * caracteres na linha e coluna de um arquivo de texto.
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public final class EncontrePalavra { //NOPMD

    /**
     * Constante padrão de arquivo UTF-8.
     */
    private static final Charset UTF8 = Charset.forName("UTF-8");

    /**
     * Váriavel para armazenar as informações das ocorrências.
     */
    private ArrayList<LinhaTexto> arquivo = new ArrayList<>();

    /**
     * Método que recebe um path de um arquivo de texto e uma palavra, faz a
     * leitura de todas buscando pelas ocorrencias da palavra.
     *
     * @param palavra  String a qual que ser encontrada no texto.
     * @param filePath Path Localização do arquivo a ser lido.
     * @return ArrayList<LinhaTexto> Array com informações de cada linha.
     * @throws IOException Erro na abertura ou leitura do arquivo.
     */
    public ArrayList<LinhaTexto> encontraOcorrencias(
            final String palavra, final Path filePath
    ) throws IOException {

        int linhaIdx = 1;
        for (final String linha : Files.readAllLines(filePath, UTF8)) {
            lerColuna(palavra, linhaIdx, linha);
            linhaIdx = linhaIdx + 1;
        }

        return arquivo;
    }

    /**
     * Método para leitura de uma linha e encontrar as ocorrencias da palavras
     * na dada linha.
     * @param palavra String Palavra a ser encontrada na linha.
     * @param linhaIdx int Index da linha.
     * @param linha String Linha do arquivo que será buscado a palavra.
     */
    private void lerColuna(final String palavra, final int linhaIdx,
                                 final String linha) {

        final String[] coluna = linha.split(" ");
        final LinhaTexto linTex = new LinhaTexto();
        int count = 0;
        for (int idx = 0; idx < coluna.length; idx++) {
            if (coluna[idx].equals(palavra)) {
                for (final String p : coluna) {
                    if (p.equals(palavra)) {
                        count = count + 1;
                    }
                }

                linTex.setLinhaInfos(count, linhaIdx, idx, linha);
                arquivo.add(linTex);
                break;
            }
        }

        if (count == 0) {
            linTex.setLinhaInfos(count, 0, 0, "");
            arquivo.add(linTex);
        }
    }
}
