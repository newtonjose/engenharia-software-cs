package com.github.newtonjose.cs.aula08.jpeg.src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Paths.get;
import static org.junit.jupiter.api.Assertions.*;

class VerificaJpegBytesTest {
    private VerificaJpegBytes verificaJpegBytes;
    private RandomAccessFile raf;
    private int fileLen;

    @Nested
    class testImagemValida {
        final String imgValid = "/home/th3clansman/Development/" +
                "projects/cs-2019-01/aula-08/jpeg/java/static/panda.jpg";

        @BeforeEach
        void inicializaClasse() {
            try {
                raf = new RandomAccessFile(imgValid,"r");
                final Path filePath = get(imgValid);
                fileLen = (int) Files.size(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        void testarContrutor() {
            verificaJpegBytes = new VerificaJpegBytes(raf);
        }

        @Test
        void verificaTipoJpeg() {
            verificaJpegBytes = new VerificaJpegBytes(raf);
            try {
                assertTrue(verificaJpegBytes.verificaTipoJpeg(fileLen));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Nested
    class testImagemInvalida {
        final String imgInvalid = "/home/th3clansman/Development/" +
                "projects/cs-2019-01/aula-08/jpeg/java/static/mario.png";

        @BeforeEach
        void inicializaClasse() {
            try {
                raf = new RandomAccessFile(imgInvalid, "r");
                final Path filePath = get(imgInvalid);
                fileLen = (int) Files.size(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        void verificaTipoInvalido() {
            verificaJpegBytes = new VerificaJpegBytes(raf);
            try {
                assertFalse(verificaJpegBytes.verificaTipoJpeg(fileLen));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Nested
    class testAquivoInvalido {
        final String imgInvalid = "/home/th3clansman/Development/" +
                "projects/cs-2019-01/aula-08/jpeg/java/static/texto.txt";

        @BeforeEach
        void inicializaClasse() {
            try {
                raf = new RandomAccessFile(imgInvalid,"r");
                final Path filePath = get(imgInvalid);
                fileLen = (int) Files.size(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        void verificaTipoInvalido() {
            verificaJpegBytes = new VerificaJpegBytes(raf);
            try {
                assertFalse(verificaJpegBytes.verificaTipoJpeg(fileLen));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
