package com.github.newtonjose.ufg.cs.domain.jsonserialize;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.notafiscal.NotaFiscal;
import com.github.newtonjose.ufg.cs.domain.jsonserialize.utils.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by aluno on 13/06/19.
 */
public class FromJsonToNotaFiscal {

    private static Log logger = new Log(FromJsonToNotaFiscal.class);

    public static void readJsonFile() throws IOException {
        // REF.: https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
        ObjectMapper objectMapper = new ObjectMapper();


        //converting json to Map
        byte[] mapData = Files.readAllBytes(Paths.get("./static/nota_fiscal.json"));
        HashMap myMap;

        NotaFiscal notaFiscal = objectMapper.readValue(
                new File("./static/nota_fiscal.json"), NotaFiscal.class
        );

        logger.info(notaFiscal.toString());


//        myMap = objectMapper.readValue(mapData, HashMap.class);
//        for(Object key : myMap.keySet()) {
//            logger.info("Map is: " + myMap.get(key));
//        }

    }
}
