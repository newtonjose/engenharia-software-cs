package com.github.newtonjose.ufg.cs.domain.jsonserialize.utils;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by aluno on 13/06/19.
 */
public class Log {

    private final Logger logger;

    public Log(final Class cls) {
        this.logger = LogManager.getLogger(cls);
    }

    public void info(final String msg) {
        if(logger.isDebugEnabled()){
            logger.debug(msg);
        }

//        if(logger.isInfoEnabled()){
//            logger.info(msg, Level.DEBUG);
//        }
    }
}
