package com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal;

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

    /**TODO: Usar reguex dataNode.asText().matches(".+/.+\\.[0-9]+");*/

    public void setData(final String dt) {
        this.data = dt;
    }

    public void setTotal(final Double ttl) {
        this.total = ttl;
    }

    public void setItem(ItemNotaFiscal itemNota) {
        this.itens.add(itemNota);
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
