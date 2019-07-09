/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.newtonjose.exemplo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Reúne uma data e o dia da semana correspondente.
 * Criada exclusivamente para ilustrar a resposta via RESTFul API.
 */
public class DirencaEntreDatas {

    private final LocalDate data;
    private final String diaDaSemana;

    public DirencaEntreDatas(LocalDate data, String diaDaSemana) {
        this.data = data;
        this.diaDaSemana = diaDaSemana;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    /**
     * Calcula a dirence de dias entre duas datas.
     *
     * @param dateI Date Data inicial.
     * @param dateF Date Data final.
     * @return long Número de dias entre as duas datas.
     */
    public static long getDataEmDias(final Date dateI, final Date dateF) {
        final long diff = dateI.getTime() - dateF.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
