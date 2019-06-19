package com.github.newtonjose.cs.aula07.estruturas;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SorteioAleatorioTest {

    @Test
    void sortear() {
        final Map map = SorteioAleatorio.sortear();

        for (Object o: map.entrySet()) {
            final Map.Entry entry = (Map.Entry) o;
            System.out.println("Numero: " + entry.getKey() + " Ocorrencias: "
                    + entry.getValue());
        }
    }
}