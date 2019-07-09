/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.newtonjose.exemplo.application.api;

import com.github.newtonjose.exemplo.domain.DirencaEntreDatas;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DirencaEntreDatasController {

    @CrossOrigin
    @RequestMapping("ds")
    public DirencaEntreDatas diaDaSemana(
            @RequestParam(value = "dataI") String dataInicial,
            @RequestParam(value="dataF") String dataFinal
    ) {

        final Date dataI = localDateFromString(dataInicial);
        final Date dateF = localDateFromString(dataFinal);

        final long days = DirencaEntreDatas.getDataEmDias(dataI, dateF);

        return null; //new DirencaEntreDatas(days);
    }

    /**
     * Recupera a instância de {@link Date} correspondente à sequência
     * de caracteres.
     * @param date Sequência de caracteres no formato dd-MM-yyyy.
     *
     * @return Instância de {@link Date} ou {@code null}, se a sequência
     * não está no formato esperado (por exemplo, "01-01-2018")
     */
    private Date localDateFromString(String date) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd MM yyyy");
            return fmt.parse(date);
        } catch (Exception exp) {
            return null;
        }
    }
}
