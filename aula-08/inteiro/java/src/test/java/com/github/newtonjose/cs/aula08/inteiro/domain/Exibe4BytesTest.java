package com.github.newtonjose.cs.aula08.inteiro.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Paths.get;
import static org.junit.jupiter.api.Assertions.*;

class Exibe4BytesTest {
    private Exibe4Bytes exibe4Bytes;
    private RandomAccessFile raf;

    @BeforeEach
    void setUp() {
        exibe4Bytes = new Exibe4Bytes();
        assertNotNull(exibe4Bytes);

        final String imgValid = "/home/th3clansman/Development/" +
                "projects/cs-2019-01/aula-08/jpeg/java/static/panda.jpg";

        try {
            raf = new RandomAccessFile(imgValid,"r");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void get4PrimeirosBytesHexadecimal() throws IOException {
        String[] expected = new String[]{"ffff", "ffd8", "ffff", "ffe0"};
        String[] ret = exibe4Bytes.get4PrimeirosBytesHexadecimal(raf);
        assertArrayEquals(expected, ret);
    }
}