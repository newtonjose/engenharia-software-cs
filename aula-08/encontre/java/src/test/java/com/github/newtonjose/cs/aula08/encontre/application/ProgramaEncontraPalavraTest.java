package com.github.newtonjose.cs.aula08.encontre.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramaEncontraPalavraTest {

    private String[] args;

    @Test
    void testMainSucesso() {
        args = new String[]{"./static/readme.txt", "software"};
        ProgramaEncontraPalavra.main(args);
    }
}
