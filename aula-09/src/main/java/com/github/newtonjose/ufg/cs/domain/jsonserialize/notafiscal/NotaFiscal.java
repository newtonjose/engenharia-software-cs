package com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by aluno on 13/06/19.
 */
public class NotaFiscal {
    private String data;
    private Double total;
    private ArrayList<ItemNotaFiscal> itens = new ArrayList<ItemNotaFiscal>();;

    private StringBuilder stringBuilder = new StringBuilder();

    public void setData(String data) {
        this.data = data;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

//    public NotaFiscal(final String data, final Double total) {
//        this.data = data;
//        this.total = total;
//    }

    public void setItens(final ArrayList itens) {
        for (final Object item: itens) {
            final Integer quantidade = (Integer) ((Map.Entry) (
                    (LinkedHashMap) item).entrySet().toArray()[0]).getValue();

            final Double preco = (Double) ((Map.Entry) (
                    (LinkedHashMap) item).entrySet().toArray()[1]).getValue();

            final Integer codigo = (Integer) ((Map.Entry) (
                    (LinkedHashMap) item).entrySet().toArray()[2]).getValue();

            final String descricao = (String) ((Map.Entry) (
                    (LinkedHashMap) item).entrySet().toArray()[3]).getValue();

            final ItemNotaFiscal itemNota = new ItemNotaFiscal(quantidade,
                    preco, codigo, descricao);

            this.itens.add(itemNota);
        }
    }

    @Override
    public String toString() {
        stringBuilder.append(this.data);
        stringBuilder.append(this.total);
        stringBuilder.append(this.itens);

        return stringBuilder.toString();
    }

}
