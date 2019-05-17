package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste da função main da classe Aplicação.
 */
class AplicacaoTest extends Aplicacao {

    @Test
    void testaMain() {
        Aplicacao instance = new Aplicacao();
        String [] args = {};
        main(args);
    }
}