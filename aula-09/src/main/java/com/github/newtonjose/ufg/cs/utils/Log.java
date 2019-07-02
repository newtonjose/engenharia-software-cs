package com.github.newtonjose.ufg.cs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;

/**
 * Classe Log com implementação dos métodos que são usados para logar as ações
 * e erros da aplicação.
 */
public class Log {

    /**
     * Atributo usado como instância de LogManager.getLogger.
     */
    private final Logger logger;

    /**
     * Construtor com a inicialização do atributo logger.
     *
     * @param cls Class classe que será logável.
     */
    public Log(final Class cls) {
        this.logger = LogManager.getLogger(cls.getName());
    }

    /**
     * Método para logar uma info.
     *
     * @param msg String Messagem a ser logada.
     */
    public void info(final String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    /**
     * Método para logar uma expection.
     * @param msg String Messagem da exception.
     * @param exp Exception
     */
    public void error(final String msg, final Exception exp) {
        if (logger.isErrorEnabled()) {
            logger.error(msg + " " + exp);
        }
    }

    /**
     * Método para exception fatal.
     * @param msg String Messagem da exception.
     * @param nsae NoSuchAlgorithmException
     */
    public void fatal(final String msg, final NoSuchAlgorithmException nsae) {
        if (logger.isFatalEnabled()) {
            logger.fatal(msg + " " + nsae);
        }
    }
}
