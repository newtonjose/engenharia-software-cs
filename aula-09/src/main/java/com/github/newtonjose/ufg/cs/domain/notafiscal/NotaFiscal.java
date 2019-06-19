package com.github.newtonjose.ufg.cs.domain.notafiscal;

import java.util.ArrayList;

/**
 * Created by aluno on 13/06/19.
 */
public class NotaFiscal {
    private String data;
    private Double total;

    ArrayList<ItemNotaFiscal> items;

    public NotaFiscal(final String data, final Double total) {
        this.data = data;
        this.total = total;
    }

    public void putItemNotaFiscal(final ItemNotaFiscal item) {
        this.items.add(item);
    }
}
