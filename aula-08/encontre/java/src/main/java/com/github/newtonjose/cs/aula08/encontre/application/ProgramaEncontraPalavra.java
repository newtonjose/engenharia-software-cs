package com.github.newtonjose.cs.aula08.encontre.application;


import com.github.newtonjose.cs.aula08.encontre.domain.EncontrePalavra;
import com.github.newtonjose.cs.aula08.encontre.domain.LinhaTexto;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Implementação da classe principal do programa EncontraPalavra.
 * <p>Classe principal para execução da abertura do arquivo e instanciar classe
 * que encontra ocorrencias de uma palavra no texto passado como parâmetro.
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public final class ProgramaEncontraPalavra {

    /**
     * Constante usada como saída padrão.
     */
    private static final Logger LOGGER = Logger.getLogger(
            ProgramaEncontraPalavra.class.getName()
    );

    /**
     * Construtor privado pois a classe é final.
     */
    private ProgramaEncontraPalavra() {

    }

    /**
     * Método main que instancia a classe EncontrePalavra recebe um arquivo
     * e uma palavra como parâmetros.
     * <p>Imprime uma linha, como a linha, coluna e a coluna respectivamente
     * caso exista ocorrencia da palavra no texto.
     * @param argv Path do arquivo e a palavra a ser encontrada.
     */
    public static void main(final String[] argv) {

        EncontrePalavra encontrePalavra = new EncontrePalavra();
        Path arquivo = Paths.get(argv[0]);

        try {
            ArrayList<LinhaTexto> linhaTextos =
                    encontrePalavra.encontraOcorrencias(argv[1], arquivo);

            boolean ocorrencias = false;

            for (final LinhaTexto lin: linhaTextos) {
                if (lin.getOcorrencias() != 0) {
                    LOGGER.info("L" + lin.getNumLinha() + " C"
                            + lin.getNumColuna() + ": " + lin.getLinha());

                    ocorrencias = true;
                }
            }

            if (!ocorrencias) {
                LOGGER.info("Encontradas: 0.");
            }
        } catch (IOException ioe) {
            LOGGER.warning(String.valueOf(ioe));
            System.exit(1);
        }
    }
}
