package com.github.newtonjose.cs.aula08.inteiro.application;

import com.github.newtonjose.cs.aula08.inteiro.domain.Exibe4Bytes;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Implementação da classe principal do programa Exibe4Bytes.
 * <p>Classe principal para execução da abertura do arquivo e instanciar classe
 * que retorna os 4 primeiros bytes convertido em hexadecimal.
 *
 * @author Josenilton Santos
 * @version 1.0
 */
public final class ProgramaExibe4Bytes {
    /**
     * Constante usada como saída padrão.
     */
    private static final Logger LOGGER = Logger.getLogger(
            ProgramaExibe4Bytes.class.getName()
    );

    /**
     * Construtor privado pois a classe é final.
     */
    private ProgramaExibe4Bytes() {

    }

    /**
     * Método main que instancia a classe Exibe4Bytes recebe um aquivo
     * como entrada e loga a saída.
     * <p>Imporime os quatros primeiros bytes em hexadecimal de um arquivo.</p>
     * @param argv Nome do arquivo
     * @throws IOException Caso o aquivo não seja encontrado ou não seja
     *                     possivel fazer a leitura.
     */
    public static void main(final String[] argv) {

        try (RandomAccessFile raf = new RandomAccessFile(argv[0], "r")) {

            final Exibe4Bytes e4b = new Exibe4Bytes();

            final String[] primeiros4Hexa = e4b.get4PrimeirosBytesHexadecimal(
                    raf
            );

            System.out.println("Os quatros primeiros Hexadecimal: " //NOPMD
                        + Arrays.toString(primeiros4Hexa));
        } catch (IOException ioe) {
            LOGGER.warning(ioe.getMessage());
        }
    }
}
