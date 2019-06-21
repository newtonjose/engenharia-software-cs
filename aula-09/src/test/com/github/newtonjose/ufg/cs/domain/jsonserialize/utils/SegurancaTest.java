package com.github.newtonjose.ufg.cs.domain.jsonserialize.utils;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SegurancaTest {

    @Test
    void getHashSH256() throws NoSuchAlgorithmException {
        byte[] data = "Message to digest".getBytes();

        Seguranca seg = new Seguranca();
        byte[] bytes = seg.getHashSH256(data);

        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());

        assertEquals(bytes, data);
    }
}