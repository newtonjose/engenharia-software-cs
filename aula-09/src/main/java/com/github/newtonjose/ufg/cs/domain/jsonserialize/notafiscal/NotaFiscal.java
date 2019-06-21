package com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 13/06/19.
 */

public class NotaFiscal {
    private String data;
    private Double total;
    private List<ItemNotaFiscal> itens = new ArrayList<>();

    private final StringBuilder stringBuilder = new StringBuilder();

    private void validaFormatoData(final String date) throws ParseException {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.parse(date);
    }
    /**
     * Recebe uma data e valida se está no formato: DD/MM/YYYY.
     * @param dt String Data de um ano em formato dd/MM/yyyy.
     * @throws ParseException Se uma data não está no formato.
     */
    public void setData(final String dt) throws ParseException {
        validaFormatoData(dt);
        this.data = dt;
    }

    public void setTotal(final Double ttl) {
        this.total = ttl;
    }

    public void setItem(ItemNotaFiscal itemNota) {
        this.itens.add(itemNota);
    }

    public void setItens(List listItens) {
        this.itens = listItens;
    }

    public int getDataAsInt() {
        final String[] dayMonthYear = this.data.split("/");
        return Integer.parseInt(
                dayMonthYear[2] + dayMonthYear[1] + dayMonthYear[0]
        );
    }

    public double getTotal() {
        return this.total;
    }

    public List<ItemNotaFiscal> getItens() {
        return this.itens;
    }

    @Override
    public String toString() {
        stringBuilder.append(this.data).append(" ");
        stringBuilder.append(this.total).append(" ");
        stringBuilder.append("Itens: ");
        for (ItemNotaFiscal item: this.itens) {
            stringBuilder.append(item.toString()).append(" ");
        }

        return stringBuilder.toString();
    }
}
