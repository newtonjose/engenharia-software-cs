package com.github.newtonjose.ufg.cs.application.jsonserializewatch;

import com.github.newtonjose.ufg.cs.domain.jsonserialize.ConversorJson;
import com.github.newtonjose.ufg.cs.utils.Log;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.security.NoSuchAlgorithmException;

/**
 * Implementação da classe principal do programa que serializa arquivos json.
 *
 * <p>Classe main responsável por inicializar o programa obtém a váriavel
 * de ambiente e iniciar o monitoramento do diretório de entrada dos arquivos
 * json</p>
 */
public final class ConversaoUseCase {

    /**
     * Constante com valor do path do diretório a ser monitorado.
     */
    private static final String NOTASFISCAIS = System.getenv("NOTAS_FISCAIS");

    /**
     * Constante com instância de logger.
     */
    private static final Log LOG = new Log(ConversaoUseCase.class);

    /**
     * Construtor privado pois a classe não é instanciável.
     */
    private ConversaoUseCase() {

    }

    /**
     * Método main que verifica se a variável de ambiente foi inicializada,
     * executa o watchService para monitorar o repositório json/ e instancia,
     * o programa de serialização do arquivo .json.
     * @param args Argumentos default do método main, mas não usados.
     */
    public static void main(final String[] args) {

        if (NOTASFISCAIS == null) {
            LOG.info("Váriável de ambiente NOTAS_FISCAIS não foi"
                    + " inicializada.");
            return;
        }

        Path path = Paths.get(NOTASFISCAIS + "json/");

        final ConversorJson convJson = new ConversorJson(NOTASFISCAIS);

        try {
            final WatchService watchService =
                    FileSystems.getDefault().newWatchService();

            path.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE
            );

            LOG.info("Serviço serialização de arquivos json em "
                    + "operação...");
            LOG.info("Diretório " + NOTASFISCAIS + "json/ disponível "
                    + "para armazenar os arquivos .json");

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    LOG.info("Arquivo detectado: " + event.context());
                    convJson.realizaConversao(event.context().toString());
                }
                key.reset();
            }
        } catch (IOException e) {
            LOG.error(e);
        } catch (InterruptedException e) {
            LOG.info("Programa encerrado...");
            Thread.currentThread().interrupt();
        } catch (NoSuchAlgorithmException e) {
            LOG.fatal(e);
            System.exit(1);
        }
    }
}
