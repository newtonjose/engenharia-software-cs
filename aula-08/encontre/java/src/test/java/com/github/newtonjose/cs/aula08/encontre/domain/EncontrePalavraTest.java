package com.github.newtonjose.cs.aula08.encontre.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EncontrePalavraTest {
    private EncontrePalavra encontrePalavra;
    Path arquivo;

    @BeforeEach
    void setUp() {
        encontrePalavra = new EncontrePalavra();
        assertNotNull(encontrePalavra);

        arquivo = Paths.get("./src/main/java/com.github.newtonjose.cs."
                + "aula08.encontre.domain.EncontrePalavra");

    }

    @Test
    void encontraLinhaColuna() throws IOException {
        ArrayList<LinhaTexto> lt = encontrePalavra.encontraOcorrencias(
                "int", arquivo
        );
    }
}