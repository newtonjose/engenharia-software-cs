package com.github.newtonjose.cs.aula08.jpeg.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgramaVerificaJPEGTest {
    private String[] args;

    @BeforeEach
    void initPath() {
        final String imgValid = "/home/th3clansman/Development/" +
                "projects/cs-2019-01/aula-08/jpeg/java/static/";

        args = new String[]{imgValid};
    }

    @Test
    void testMainSucesso() {
        args[0] = args[0] + "panda.jpg";
        ProgramaVerificaJPEG.main(args);
    }

    @Test
    void testMainFalha() {
        args[0] = args[0] + "mario.png";
        ProgramaVerificaJPEG.main(args);
    }

    @Test
    void testMainAquivoNaoExiste() {
        args[0] = args[0] + "notFount.jpg";
        ProgramaVerificaJPEG.main(args);
    }

}