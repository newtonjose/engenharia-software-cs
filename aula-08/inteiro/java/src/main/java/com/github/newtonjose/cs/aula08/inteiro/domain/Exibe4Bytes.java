package com.github.newtonjose.cs.aula08.inteiro.domain;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Implementação da classe que retorna os 4 primeiros bytes.
 * <p>Classe faz a leitura dos 4 primeiros bytes e converte para hexadecimal.
 * </p>
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public final class Exibe4Bytes { //NOPMD: AtLeastOneConstructorRule

    /**
     * Constante usada no método ler4PrimeirosBytes.
     */
    private static final int FOUR_BYTES = 4;

    /**
     * Hexadecimal base usado como conversor no método
     * get4PrimeirosBytesHexadecimal.
     */
    private static final int BASE_HEX = 0xffff;
    /**
     * Método que ler os quatros primeiro bytes de um arquivo.
     * @param raf Referência do arquivo a ser lido.
     * @return String[] - Array com os quatros primeiros bytes.
     * @throws IOException Error de leitura.
     */
    private byte[] ler4PrimeirosBytes(final RandomAccessFile raf)
            throws IOException {
        final byte[] data = new byte[FOUR_BYTES];
        raf.read(data);

        return data;
    }

    /**
     * Método que converte os 4 primeiros bytes em hexadecimal.
     * @param raf Referência do arquivo a ser lido.
     * @return String[] - Array de hexadecimal.
     * @throws IOException Error de leitura.
     */
    public String[] get4PrimeirosBytesHexadecimal(final RandomAccessFile raf)
            throws IOException {
        final byte[] fourInBytes = ler4PrimeirosBytes(raf);

        final String[] byteToHexa = new String[fourInBytes.length]; //NOPMD
        // DataflowAnomalyAnalysis

        for (int i = 0; i < fourInBytes.length; i++) {
            final byte byt = fourInBytes[i];
            final String hex = Integer.toHexString((int) byt & BASE_HEX);
            byteToHexa[i] = hex; //NOPMD DataflowAnomalyAnalysis
        }

        return byteToHexa;
    }
}
