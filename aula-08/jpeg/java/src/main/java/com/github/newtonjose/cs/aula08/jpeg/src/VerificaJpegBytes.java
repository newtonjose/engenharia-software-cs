package com.github.newtonjose.cs.aula08.jpeg.src;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Implementação da classe que verifica se um dado arquivo é do tipo JPEG.
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public class VerificaJpegBytes {

    /**
     * Constante que representa o hexadecimal 255.
     */
    private static final int HEX_255 = 0xff;

    /**
     * Constante que representa o hexadecimal 216.
     */
    private static final int HEX_216 = 0xd8;

    /**
     * Constante que representa o hexadecimal 217.
     */
    private static final int HEX_217 = 0xd9;

    /**
     * Váriavel privada que recebe a referencia do arquivo.
     */
    private final transient RandomAccessFile randomAccessFile;

    /**
     * Construtor da classe, que instância a variável numBytes.
     * @param rAf RandomAccessFile - Valor inteiro dos bytes
     *            de um arquivo binário.
     */
    public VerificaJpegBytes(final RandomAccessFile rAf) {
        this.randomAccessFile = rAf;
    }

    /**
     * Método que ler os dois primeiro bytes de um arquivo.
     * @return byte[] - Array com o dois primeiros bytes do arquivo.
     * @throws IOException Caso tenha error na leitura.
     */
    private byte[] lerDoisPrimeirosBytes() throws IOException {
        final byte[] data = new byte[2];
        this.randomAccessFile.read(data);

        return data;
    }

    /**
     * Método que ler os dois últimos bytes de um arquivo.
     * @param len int Tamanho do arquivo em bytes.
     * @return byte[] - Array com o dois últimos bytes do arquivo.
     * @throws IOException Caso tenha error na leitura.
     */
    private byte[] lerDoisUltimosBytes(final int len) throws IOException {
        final byte[] data = new byte[2];
        this.randomAccessFile.seek(len - 2);
        this.randomAccessFile.read(data);

        return data;
    }

    /**
     * Método que verifica se o um número int bytes é igual ao número
     * hexadecimal, dito número mágico do tipo de arquivo JPEG.
     * @param fileLen int Tamanho do arquivo em bytes.
     * @return boolean - Verdadeiro ou Falso.
     * @throws IOException Caso tenha error na leitura.
     */
    public boolean verificaTipoJpeg(final int fileLen) throws IOException {
        final byte[] twoInBytes = lerDoisPrimeirosBytes();
        final byte[] twoFiBytes = lerDoisUltimosBytes(fileLen);

        final boolean inicioArquivo = twoInBytes[0] == (byte) HEX_255
                && twoInBytes[1] == (byte) HEX_216;

        final boolean finalArquivo = twoFiBytes[0] == (byte) HEX_255
                && twoFiBytes[1] == (byte) HEX_217;

        return inicioArquivo && finalArquivo;
    }
}
