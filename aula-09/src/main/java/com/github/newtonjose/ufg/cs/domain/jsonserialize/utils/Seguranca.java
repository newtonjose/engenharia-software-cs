package com.github.newtonjose.ufg.cs.domain.jsonserialize.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by aluno on 13/06/19.
 */
public final class Seguranca {
    private final MessageDigest messageDigest;

    public Seguranca() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public byte[] getHashSH256(final byte[] data) {
        messageDigest.update(data);

        return messageDigest.digest();
    }
}
