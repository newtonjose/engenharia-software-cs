package com.github.newtonjose.ufg.cs.domain.jsonserialize.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe que implementa o método que gera a hash sha-256.
 */
public final class Seguranca {

    /**
     * Atributo que rebera uma instancia de MessageDigest.
     */
    private final MessageDigest messageDigest;

    /**
     * Construtor que instancia o algoritmo de digestão de bytes.
     *
     * @throws NoSuchAlgorithmException Caso o algoritmo não exista no ambiente
     * local.
     */
    public Seguranca() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    /**
     * Método que recebe um array de bytes e realiza a "digestão" usando
     * o algoritmo SHA-256.
     *
     * @param data byte[] Array de bytes a ser convertido.
     * @return baty[] Array de bytes da hash gerada com 32 bytes.
     */
    public byte[] getHashSH256(final byte[] data) {
        messageDigest.update(data);

        return messageDigest.digest();
    }
}
