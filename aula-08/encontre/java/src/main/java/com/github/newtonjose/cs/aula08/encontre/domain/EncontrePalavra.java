package com.github.newtonjose.cs.aula08.encontre.domain;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


/**
 * Implementação da classe que encontra uma sequência de caracteres
 * na linha e coluna de um arquivo de texto.
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public final class EncontrePalavra { //NOPMD

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private ArrayList<LinhasTexto> arquivo = new ArrayList<>();

    public ArrayList<LinhasTexto> encontraOcorrenciasPalavras(final String palavra,
                                                              final Path filePath)
            throws IOException {
        // ler todas as linhas e encontra a primeira ocorrencia da palavra



        int linhaIdx = 1;
        for (final String linha: Files.readAllLines(filePath, UTF8)) {
            final LinhasTexto linTex = new LinhasTexto();
            final String[] coluna = linha.split(" ");

            int count = 0;
            for (int idx = 0; idx < coluna.length; idx++) {
                if (coluna[idx].equals(palavra)) {
                    for (final String p: coluna) {
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
            linhaIdx = linhaIdx + 1;
        }

        return arquivo;
    }

    private String lerLinha(final int lin, final int col) {
        // encontra linha apartir da refência.
        return null;
    }
}
