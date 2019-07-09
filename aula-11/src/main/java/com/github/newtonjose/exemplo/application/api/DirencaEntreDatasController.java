/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.newtonjose.exemplo.application.api;

import com.github.newtonjose.exemplo.domain.DirencaEntreDatas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DirencaEntreDatasController {



    @ResponseStatus(code=HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
    private void onIllegalArgumentException(IllegalArgumentException exception) {}



    @CrossOrigin
    @RequestMapping("ds")
    @ResponseBody
    public DirencaEntreDatas diaDaSemana(
            @RequestParam(value = "dataI") String dataInicial,
            @RequestParam(value="dataF") String dataFinal
    ) {

        final Date dateI = localDateFromString(dataInicial);
        final Date dateF = localDateFromString(dataFinal);

        if (dateI == null || dateF == null) {
            onIllegalArgumentException(new IllegalArgumentException("ola mundo"));
        }

        final long days = DirencaEntreDatas.getDataEmDias(dateI, dateF);

        return new DirencaEntreDatas(dateI, dateF, days);
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
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            return fmt.parse(date);
        } catch (Exception exp) {
            return null;
        }
    }
}
