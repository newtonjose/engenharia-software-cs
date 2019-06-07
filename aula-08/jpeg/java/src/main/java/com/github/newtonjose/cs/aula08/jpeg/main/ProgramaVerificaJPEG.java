package com.github.newtonjose.cs.aula08.jpeg.main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.logging.Logger;

import static java.nio.file.Files.newInputStream;
import static java.nio.file.Paths.get;
/**
 * Implementação da classe principal do programa JPEG.
 * <p>Classe principal para execução do programa que verifica se um aquivo
 * é do tipo JPEG.
 *
 * @author Josenilton Santos
 * @version 1.0
 */

public final class ProgramaVerificaJPEG {

    /**
     * Constante usada para chamar os métodos da classe Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(
            ProgramaVerificaJPEG.class.getName()
    );

    /**
     * Construtor privado pois a classe é final.
     */
    private ProgramaVerificaJPEG() {

    }



    /**
     * Método main que instancia a classe VerificaJPEG e imprime se o arquivo
     * recebido como parâmetro é do tipo JPEG ou não.
     * <p>Verifica se um arquivo é do tipo JPEG, e imprime 'sim' ou 'não'.</p>
     * @param args Argumento de entrada será o nome do arquivo disponível na
     *             pasta static. //FINDMORE: Necessário documentar exception
     * @throws IOException Caso o aquivo não seja encontrado.
     */
    public static void main(final String... args) throws IOException {

        // leitura do arquivo.
        final Path filePath = get(args[0]);
        final InputStream ipSt = newInputStream(filePath);
        final int valor = ipSt.read();

        LOGGER.fine("Valor Inteiro do Arquivo: " + valor);
    }
}
