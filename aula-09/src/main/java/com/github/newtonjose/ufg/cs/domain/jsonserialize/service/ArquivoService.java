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
 * Created by aluno on 13/06/19.
 */
public class ArquivoService {

    private String notasFiscaisDir;

    public ArquivoService(final String nfEnvVar) {
        notasFiscaisDir = nfEnvVar;
    }

    private static String convertHashToHex(final byte[] hash) {
        final StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }

        return sb.toString();
    }

    private static byte[] zipBytes(final String filename, final byte[] input)
            throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ZipOutputStream zos = new ZipOutputStream(baos);
        final ZipEntry entry = new ZipEntry(filename);

        entry.setSize(input.length);
        zos.putNextEntry(entry);
        zos.write(input);

        zos.closeEntry();
        zos.close();

        return baos.toByteArray();
    }

    public void persisteAsZip(final byte[] hash, final byte[] data)
            throws IOException {

        // converte dados em arquivo zip.
        final String hashHex = convertHashToHex(hash);
        final String fileName = notasFiscaisDir + "dat/" + hashHex + ".dat";
        final byte[] zipByteArr = zipBytes(fileName, data);

        final Path path = Paths.get(fileName);
        Files.write(path, zipByteArr);
    }

    public void copiaJsonNotaFiscal(final String fileName) throws IOException {

        final Path oldPath = Paths.get(notasFiscaisDir + "json/" + fileName);
        final Path newPath = Paths.get(notasFiscaisDir + "erros/" + fileName);
        Files.move(oldPath, newPath, REPLACE_EXISTING);
    }

    public void removeJsonNotaFiscal(final String fileName) throws IOException {
        final Path path = Paths.get(notasFiscaisDir + "json/" + fileName);
        Files.delete(path);
    }

    public void removeDatZipeFile(final byte[] hash) throws IOException {
        final String hashHex = convertHashToHex(hash);
        final String filePath = notasFiscaisDir + "dat/" + hashHex + ".dat";
        final Path path = Paths.get(filePath);
        Files.delete(path);
    }
}
