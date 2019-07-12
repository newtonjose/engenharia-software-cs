/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.newtonjose.exemplo.application.api;

import com.github.newtonjose.exemplo.application.api.customexception.DateArgumentNull;
import com.github.newtonjose.exemplo.application.api.customexception.DateFinalBeforeDateInicial;
import com.github.newtonjose.exemplo.domain.DirencaEntreDatas;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe usada como controller e implementa o endpoint
 * que calcula a direfeça entre duas datas e o método
 * para conversão de data.
 */
@RestController
public class DirencaEntreDatasController {

    /**
     * Método usado como endpoint da requisição para calcular
     * a difêreça de dias entre duas datas.
     *
     * @param dataInicial String Data inicial.
     * @param dataFinal String Data final.
     * @return DirencaEntreDatas Instância com uma messagem
     * e a diferença em dias das datas.
     *
     * @throws DateArgumentNull Se alguma das datas forem vazias.
     * @throws DateFinalBeforeDateInicial Se a data final for
     * antes da data inicial.
     */
    @CrossOrigin
    @RequestMapping("ds")
    @ResponseBody
    public DirencaEntreDatas diaDaSemana(
            @RequestParam("dataI") final String dataInicial,
            @RequestParam("dataF") final String dataFinal
    ) {

        final Date dateI = localDateFromString(dataInicial);
        final Date dateF = localDateFromString(dataFinal);

        if (dateI == null || dateF == null) {
            throw new DateArgumentNull();
        }

        if (dateF.before(dateI)) {
            throw new DateFinalBeforeDateInicial();
        }

        final long days = DirencaEntreDatas.getDataEmDias(dateI, dateF);

        return new DirencaEntreDatas(days);
    }

    /**
     * Recupera a instância de {@link Date} correspondente à sequência
     * de caracteres.
     * @param date Sequência de caracteres no formato dd-MM-yyyy.
     *
     * @return Instância de {@link Date} ou {@code null}, se a sequência
     * não está no formato esperado (por exemplo, "01-01-2018")
     */
    private Date localDateFromString(final String date) {
        try {
            final SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            return fmt.parse(date);
        } catch (ParseException p) {
            return null;
        }
    }
}
