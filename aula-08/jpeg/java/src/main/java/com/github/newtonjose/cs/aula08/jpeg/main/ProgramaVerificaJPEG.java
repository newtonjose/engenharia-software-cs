package com.github.newtonjose.cs.aula08.jpeg.main;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.github.newtonjose.cs.aula08.jpeg.src.VerificaJpegBytes;

import static java.nio.file.Paths.get;


/**
 * Implementação da classe principal do programa JPEG.
 * <p>Classe principal para execução da abertura do arquivo e instanciar classe
 * que verifica se um aquivo é do tipo JPEG.
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
     * @param argv Argumento de entrada será o nome do arquivo disponível na
     *             pasta static. //FINDMORE: Necessário documentar exception
     * @throws IOException Caso o aquivo não seja encontrado.
     */
    public static void main(final String[] argv) {

        try (RandomAccessFile raf = new RandomAccessFile(argv[0], "r")) {

            final VerificaJpegBytes vjb = new VerificaJpegBytes(raf);

            final Path filePath = get(argv[0]); //NOPMD: lawofdemeter
            final int fileLen = (int) Files.size(filePath);

            if (vjb.verificaTipoJpeg(fileLen)) {
                LOGGER.info("Arquivo é JPEG!");
            } else {
                LOGGER.info("Arquivo não JPEG!");
            }
        } catch (IOException ioe) {
            LOGGER.warning(ioe.getMessage());
        }
    }
}
