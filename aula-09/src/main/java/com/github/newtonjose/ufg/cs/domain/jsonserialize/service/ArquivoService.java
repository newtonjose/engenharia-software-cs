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

    private static final String NOTAS_FISCAIS = "./static/";

    private static String convertHashToHex(final byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }

        return sb.toString();
    }

    private static byte[] zipBytes(String filename, byte[] input)
            throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);
        ZipEntry entry = new ZipEntry(filename);

        entry.setSize(input.length);
        zos.putNextEntry(entry);
        zos.write(input);

        zos.closeEntry();
        zos.close();

        return baos.toByteArray();
    }

    public void persisteAsZip(final byte[] hash, byte[] data)
            throws IOException {

        // converte dados em arquivo zip.

        final String hashHex = convertHashToHex(hash);
        final String fileName = NOTAS_FISCAIS + "dat/" + hashHex + ".dat";
        final byte[] zipByteArr = zipBytes(fileName, data);

        Path path = Paths.get(fileName);
        Files.write(path, zipByteArr);
    }

    public void copiaJsonNotaFiscal(final String fileName) throws IOException {

        Path oldPath = Paths.get(NOTAS_FISCAIS + "json/" + fileName);
        Path newPath = Paths.get(NOTAS_FISCAIS + "erros/" + fileName);
        Files.move(oldPath, newPath, REPLACE_EXISTING);
    }

    public void removeJsonNotaFiscal(final String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.delete(path);
    }

    public void removeDatZipeFile(final byte[] hash) throws IOException {
        final String hashHex = convertHashToHex(hash);
        final String filePath = NOTAS_FISCAIS + "dat/" + hashHex + ".dat";
        Path path = Paths.get(filePath);
        Files.delete(path);
    }
}
