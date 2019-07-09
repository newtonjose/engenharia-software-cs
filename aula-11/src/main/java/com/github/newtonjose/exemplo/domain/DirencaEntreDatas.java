/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.newtonjose.exemplo.domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Reúne uma data e o dia da semana correspondente.
 * Criada exclusivamente para ilustrar a resposta via RESTFul API.
 */
public class DirencaEntreDatas {

    private final long days;
    private final String msg;

    /**
     * Objeto que será rendenrizado como resposta da API.
     *
     * @param dateI Date Data inicial.
     * @param dateF Date Data final.
     * @param diff long Número de dias entre as datas.
     */
    public DirencaEntreDatas(final Date dateI, final Date dateF,
                             final long diff) {
        this.msg = "Diferença entre as datas: " + dateI + " e " + dateF;
        this.days = diff;

    }

    public long getDays() {
        return days;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * Calcula a dirence de dias entre duas datas.
     *
     * @param dateI Date Data inicial.
     * @param dateF Date Data final.
     * @return long Número de dias entre as duas datas.
     */
    public static long getDataEmDias(final Date dateI, final Date dateF) {
        final long diff = dateF.getTime() - dateI.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
