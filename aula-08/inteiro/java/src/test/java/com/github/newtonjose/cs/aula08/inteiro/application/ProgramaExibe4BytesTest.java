package com.github.newtonjose.cs.aula08.inteiro.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramaExibe4BytesTest {

    private String[] args;

    @Test
    void testMainSucesso() {
        args = new String[]{"./static/panda.jpg"};
        ProgramaExibe4Bytes.main(args);
    }

    @Test
    void testMainArquivoTxt() {
        args = new String[]{"./static/texto.txt"};
        ProgramaExibe4Bytes.main(args);
    }

    @Test
    void testMainArquivoNaoExisite() {
        args = new String[]{"./static/404.txt"};
        ProgramaExibe4Bytes.main(args);
    }

}
