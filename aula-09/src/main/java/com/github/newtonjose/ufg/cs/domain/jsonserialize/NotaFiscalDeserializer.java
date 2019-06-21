package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.ItemNotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;

import java.io.IOException;
import java.util.Objects;

public class NotaFiscalDeserializer extends StdDeserializer<NotaFiscal> {


        public NotaFiscalDeserializer() {
            this(null);
        }

        public NotaFiscalDeserializer(Class<?> vc) {
            super(vc);
        }

        private static void verificaCampoExiste(JsonNode node, String field)
                throws IOException {
            try {
                Objects.requireNonNull(node);
            } catch (NullPointerException npe) {
                throw new IOException("field " + field +  " cant be null ");
            }
        }

        @Override
        public NotaFiscal deserialize(JsonParser parser,
                                      DeserializationContext deserializer)
                throws IOException {

            NotaFiscal notaFiscal = new NotaFiscal();
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);

            // try catch block

            JsonNode dataNode = node.get("data");
            verificaCampoExiste(dataNode, "data");
            notaFiscal.setData(dataNode.asText());

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
