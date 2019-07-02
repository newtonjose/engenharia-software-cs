package com.github.newtonjose.ufg.cs.domain.jsonserialize.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Implementação da classe com serviços para manipulação de arquivos.
 *
 * <p>Classe com métodos de conversão para hexadecimal, criar formato tipo
 * zipe, salvar arquivo, copiar ou remover um arquivo do tipo json.</p>
 */
public class ArquivoService {

    /**
     * Variável para o path diretório com as notas fiscais.
     */
    private final String notasFiscaisDir;

    /**
     * Construtor que inicializa a variável com path do diretório das notas.
     *
     * @param nfEnvVar String Path do diretório base.
     */
    public ArquivoService(final String nfEnvVar) {
        notasFiscaisDir = nfEnvVar;
    }

    /**
     * Metodo de conversão de array de bytes em string de hexa decimal.
     *
     * @param hash byte[] Array de bytes a ser convertido.
     * @return String Array convertido em um string de hexadecimal.
     */
    private static String convertHashToHex(final byte[] hash) {
        final StringBuilder sb = new StringBuilder();
        for (final byte b : hash) {
            sb.append(String.format("%02X", b));
        }

        return sb.toString();
    }

    /**
     * Método de criação do formato zip em memória.
     *
     * @param filepath String Path do arquivo.
     * @param input byte[] Array de bytes a ser convertido no formato zip.
     * @return byte[] Array de bytes em formato binário.
     * @throws IOException Caso uma exista error no path do arquivo.
     */
    private static byte[] zipBytes(final String filepath, final byte[] input)
            throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ZipOutputStream zos = new ZipOutputStream(baos);
        final ZipEntry entry = new ZipEntry(filepath);

        entry.setSize(input.length);
        zos.putNextEntry(entry);
        zos.write(input);

        zos.closeEntry();
        zos.close();

        return baos.toByteArray();
    }

    /**
     * Método de persistência de do arquivo como tipo zip.
     *
     * @param hash byte[] Array de bytes da hash dos bytes do arquivo.
     * @param data byte[] Array de bytes do objeto json.
     * @throws IOException Caso exita error na escrita do arquivo.
     */
    public void persisteAsZip(final byte[] hash, final byte[] data)
            throws IOException {

        final String hashHex = convertHashToHex(hash);
        final String fileName = notasFiscaisDir + "dat/" + hashHex + ".dat";
        final byte[] zipByteArr = zipBytes(fileName, data);

        final Path path = Paths.get(fileName);
        Files.write(path, zipByteArr);
    }

    /**
     * Método para copiar o arquivo json para a pasta erros/ em caso de error
     * de leitura, conversão ou na hora de salvar.
     *
     * @param fileName String Nome do arquivo json.
     * @throws IOException Caso exista erro ao mover o arquivo.
     */
    public void copiaJsonNotaFiscal(final String fileName) throws IOException {

        final Path oldPath = Paths.get(notasFiscaisDir + "json/" + fileName);
        final Path newPath = Paths.get(notasFiscaisDir + "erros/" + fileName);
        Files.move(oldPath, newPath, REPLACE_EXISTING);
    }

    /**
     * Método para a remoção do arquivo da pasta json/.
     *
     * @param fileName String Nome do arquivo json.
     * @throws IOException Caso exite error ao deletar o arquivo.
     */
    public void removeJsonNotaFiscal(final String fileName) throws IOException {
        final Path path = Paths.get(notasFiscaisDir + "json/" + fileName);
        Files.delete(path);
    }
}
