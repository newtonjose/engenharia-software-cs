package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.ItemNotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

public class NotaFiscalDeserializer extends StdDeserializer<NotaFiscal> {

    public NotaFiscalDeserializer() {
            this(null);
        }

    public NotaFiscalDeserializer(final Class<?> vc) {
            super(vc);
        }

    private static void verificaCampoExiste(final JsonNode node, final String field)
                throws IOException {
            try {
                Objects.requireNonNull(node);
            } catch (NullPointerException npe) {
                throw new IOException("field " + field +  " cant be null ");
            }
        }

        @Override
        public NotaFiscal deserialize(final JsonParser parser,
                                      final DeserializationContext deserializer)
                throws IOException {

            NotaFiscal notaFiscal = new NotaFiscal();
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);

            JsonNode dataNode = node.get("data");
            verificaCampoExiste(dataNode, "data");
            try {
                notaFiscal.setData(dataNode.asText());
            } catch (ParseException pe) {
                throw new IOException(
                        "campo data fora do formato: dd/MM/yyyy."
                );
            }

            JsonNode totalNode = node.get("total");
            verificaCampoExiste(totalNode, "total");
            notaFiscal.setTotal(totalNode.asDouble());

            JsonNode itensNode = node.get("itens");
            verificaCampoExiste(itensNode, "itens");

            for (JsonNode jn: itensNode) {
                JsonNode qtdNode = jn.get("quantidade");
                verificaCampoExiste(qtdNode, "itens: quantidade");

                JsonNode prNode = jn.get("preco");
                verificaCampoExiste(prNode, "itens: preco");

                JsonNode codNode = jn.get("codigo");
                verificaCampoExiste(codNode, "itens: codigo");

                JsonNode desNode = jn.get("descricao");
                verificaCampoExiste(desNode, "itens: descicrao");

                final ItemNotaFiscal itemNota = new ItemNotaFiscal(qtdNode.asInt(),
                        prNode.asDouble(), codNode.asInt(), desNode.asText());

                notaFiscal.setItem(itemNota);
            }

            return notaFiscal;
        }
}
