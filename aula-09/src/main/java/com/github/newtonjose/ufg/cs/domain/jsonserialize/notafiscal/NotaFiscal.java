package com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aluno on 13/06/19.
 */
public class NotaFiscal {
    private String data;
    private Double total;

    private List<ItemNotaFiscal> itens = new ArrayList<>();
    private final StringBuilder stringBuilder = new StringBuilder();

    public void setData(final String dt) {
        this.data = dt;
    }

    public void setTotal(final Double ttl) {
        this.total = ttl;
    }

    public void setItens(final List itensNF) {
        for (final Object item: itensNF) {
            Object[] obj = ((LinkedHashMap) item).entrySet().toArray();

            final Integer quantidade = (Integer) ((Map.Entry) obj[0]).getValue();

            final Double preco = (Double) ((Map.Entry) obj[1]).getValue();

            final Integer codigo = (Integer) ((Map.Entry) obj[2]).getValue();

            final String descricao = (String) ((Map.Entry) obj[3]).getValue();

            final ItemNotaFiscal itemNota = new ItemNotaFiscal(quantidade,
                    preco, codigo, descricao);

            this.itens.add(itemNota);
        }
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
