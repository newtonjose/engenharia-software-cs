package com.github.newtonjose.ufg.cs.domain.notafiscal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da classe que representa uma nota fiscal.
 *
 * <p>Classe com os parâmetros e métodos uma nota fiscal.</p>
 */
public class NotaFiscal {
    /**
     * Campo que representa a data de uma nota fiscal.
     */
    private String data;

    /**
     * Campo que representa a total de uma nota fiscal.
     */
    private Double total;

    /**
     * Lista para armazenar os objetos ItemNotaFiscal.
     */
    private List<ItemNotaFiscal> itens = new ArrayList<>();

    /**
     * Método de validação do formato de uma data: dd/MM/yyyy.
     *
     * @param date String Data a ser validada.
     * @throws ParseException Caso a data não esteja no formato.
     */
    private void validaFormatoData(final String date) throws ParseException {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.parse(date);
    }
    /**
     * Recebe uma data e valida se está no formato: DD/MM/YYYY.
     *
     * @param dt String Data de um ano em formato dd/MM/yyyy.
     * @throws ParseException Se uma data não está no formato.
     */
    public void setData(final String dt) throws ParseException {
        validaFormatoData(dt);
        this.data = dt;
    }

    /**
     * Método para adicionar total de uma nota fiscal.
     *
     * @param ttl Double Total.
     */
    public void setTotal(final Double ttl) {
        this.total = ttl;
    }

    /**
     * Método para adicionar um item na nota fiscal.
     *
     * @param itemNota ItemNotaFiscal Instancia do item da nota fiscal.
     */
    public void setItem(final ItemNotaFiscal itemNota) {
        this.itens.add(itemNota);
    }

    /**
     * Método de conversão da nota fiscal em um inteiro com o padão: yyyyMMdd.
     *
     * @return int Data como inteiro.
     */
    public int getDataAsInt() {
        final String[] dayMonthYear = this.data.split("/");
        return Integer.parseInt(
                dayMonthYear[2] + dayMonthYear[1] + dayMonthYear[0]
        );
    }

    /**
     * Método de acesso a total de uma nota fiscal.
     *
     * @return double Total.
     */
    public double getTotal() {
        return this.total;
    }

    /**
     * Método de acesso a um item da nota fiscal.
     *
     * @return ItemNotaFiscal Objeto item da nota fiscal.
     */
    public List<ItemNotaFiscal> getItens() {
        return this.itens;
    }
}
