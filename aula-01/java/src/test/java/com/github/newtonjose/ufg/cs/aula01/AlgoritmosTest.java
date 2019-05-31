package com.github.newtonjose.ufg.cs.aula01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoritmosTest {

    @Test
    void calculaProdutoInteiros() {
        // Calcula valor correto
        assertEquals(8, Algoritmos.calculaProdutoInteiros(4, 2));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaProdutoInteiros(-1, 4));

        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaProdutoInteiros(1, -1));
    }


    @Test
    void calculaQuadradoPerfeito() {

        // caso de sucesso
        assertTrue(Algoritmos.verificaQuadradoPerfeito(4));

        // caso falso
        assertFalse(Algoritmos.verificaQuadradoPerfeito(3));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.verificaQuadradoPerfeito( 0));
    }

    @Test
    void calculaRestoDivisao() {

        // calcula valor correto
        assertEquals(0, Algoritmos.calculaRestoDivisao(10,2));

        // Testa entrada de argumentos invalidos
        assertThrows(IllegalArgumentException.class,
                () -> Algoritmos.calculaRestoDivisao( -1,10));
    }
}