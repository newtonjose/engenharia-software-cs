package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmosTest {

    @Test
    void calculaProdutoInteiros() {
        // Calcula valor correto
        assertEquals(8, AlgoritmosUtils.calculaProdutoInteiros(4, 2));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaProdutoInteiros(-1, 4));

        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaProdutoInteiros(1, -1));
    }


    @Test
    void calculaQuadradoPerfeito() {

        // caso de sucesso
        assertTrue(AlgoritmosUtils.verificaQuadradoPerfeito(4));

        // caso falso
        assertFalse(AlgoritmosUtils.verificaQuadradoPerfeito(3));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.verificaQuadradoPerfeito( 0));
    }

    @Test
    void calculaRestoDivisao() {

        // calcula valor correto
        assertEquals(0, AlgoritmosUtils.calculaRestoDivisao(10,2));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> AlgoritmosUtils.calculaRestoDivisao( -1,10));
    }
}