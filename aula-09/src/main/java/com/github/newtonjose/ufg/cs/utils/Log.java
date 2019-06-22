package com.github.newtonjose.ufg.cs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;

/**
 * Created by aluno on 13/06/19.
 */
public class Log {

    private final Logger logger;

    public Log(final Class cls) {
        this.logger = LogManager.getLogger(cls);
    }

    public void info(final String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public void error(final Exception exp) {
        if (logger.isErrorEnabled()) {
            logger.error(exp.toString());
        }
    }

    public void fatal(final NoSuchAlgorithmException nsae) {
        if (logger.isFatalEnabled()) {
            logger.fatal(nsae);
        }
    }
}
