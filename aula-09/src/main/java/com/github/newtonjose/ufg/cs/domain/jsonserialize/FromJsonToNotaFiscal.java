package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.newtonjose.ufg.cs.domain.notafiscal.NotaFiscal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aluno on 13/06/19.
 */
public class FromJsonToNotaFiscal {

    public static void readJsonFile() throws IOException {
        // REF.: https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
        ObjectMapper objectMapper = new ObjectMapper();

        NotaFiscal notaFiscal = objectMapper.readValue(
                new File("./static/nota_fiscal.json"), NotaFiscal.class
        );

        //converting json to Map
        byte[] mapData = Files.readAllBytes(Paths.get("data.txt"));
        Map<String,String> myMap = new HashMap<>();


        myMap = objectMapper.readValue(mapData, HashMap.class);
        System.out.println("Map is: "+myMap);

        //another way
        myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
        System.out.println("Map using TypeReference: "+myMap);

    }
}
