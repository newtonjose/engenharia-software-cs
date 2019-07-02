package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.notafiscal.ItemNotaFiscal;
import com.github.newtonjose.ufg.cs.domain.notafiscal.NotaFiscal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;

/**
 * Implementação do deserializador de um arquivo json que representa uma nota
 * fiscal.
 *
 * <p>Classe que extende de StdDeserializer implementado o método de
 * deserialização de arquivo json para objetos NotaFiscal.</p>
 */
public class NotaFiscalDeserializer extends StdDeserializer<NotaFiscal> {

    /**
     * Versão da deserializer.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor base.
     */
    public NotaFiscalDeserializer() {
        this(null);
    }

    /**
     * Construtor base 2.
     *
     * @param vc Class<?>.
     */
    public NotaFiscalDeserializer(final Class<?> vc) {
        super(vc);
    }

    /**
     * Método que verifica se um campo é nulo, no caso não está no arquivo json.
     *
     * @param node JsonNode
     * @param field String Campo a ser validado.
     * @throws IOException Se o campo for nulo.
     */
    private static void verificaCampoExiste(final JsonNode node,
                                            final String field)
            throws IOException {

        if (node == null) {
            throw new IOException("field " + field +  " cant be null ");
        }
    }

    /**
     * Método de deserialização do arquivo nota fiscal com validadores de campo.
     *
     * @param parser JsonParser
     * @param deserializer DeserializationContext
     * @return NotaFiscal Instância de NotaFiscal com os valores do aquivo que
     * está sendo deserializado.
     * @throws IOException Em caso de campo vazio e/ou formato invalido.
     */
    @Override
    public NotaFiscal deserialize(final JsonParser parser,
                                  final DeserializationContext deserializer)
            throws IOException {

        final NotaFiscal notaFiscal = new NotaFiscal();
        final ObjectCodec codec = parser.getCodec();
        final JsonNode node = codec.readTree(parser);

        final JsonNode dataNode = node.get("data");
        verificaCampoExiste(dataNode, "data");
        try {
            notaFiscal.setData(dataNode.asText());
        } catch (ParseException pe) {
            throw new IOException(
                    "campo data fora do formato: dd/MM/yyyy."
            );
        }

        final JsonNode totalNode = node.get("total");
        verificaCampoExiste(totalNode, "total");
        notaFiscal.setTotal(totalNode.asDouble());

        final JsonNode itensNode = node.get("itens");
        verificaCampoExiste(itensNode, "itens");

        for (final JsonNode jn: itensNode) {
            final JsonNode qtdNode = jn.get("quantidade");
            verificaCampoExiste(qtdNode, "itens: quantidade");

            final JsonNode prNode = jn.get("preco");
            verificaCampoExiste(prNode, "itens: preco");

            final JsonNode codNode = jn.get("codigo");
            verificaCampoExiste(codNode, "itens: codigo");

            final JsonNode desNode = jn.get("descricao");
            verificaCampoExiste(desNode, "itens: descicrao");

            final ItemNotaFiscal itemNota = new ItemNotaFiscal(qtdNode.asInt(),
                    prNode.asDouble(), codNode.asInt(), desNode.asText());

            notaFiscal.setItem(itemNota);
        }

        return notaFiscal;
    }
}
