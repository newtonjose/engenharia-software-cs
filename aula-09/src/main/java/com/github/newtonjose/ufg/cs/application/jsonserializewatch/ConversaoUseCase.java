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
import java.util.Objects;

/**
 * Created by aluno on 13/06/19.
 */
public final class ConversaoUseCase {

    private static final String NOTASFISCAIS = System.getenv("NOTAS_FISCAIS");
    private static final Log LOG = new Log(ConversaoUseCase.class);

    public static void main(final String[] args) {
        try {
            Objects.requireNonNull(NOTASFISCAIS);
        } catch (NullPointerException npe) {
            LOG.info("Váriável de ambiente NOTAS_FISCAIS não foi"
                    + " inicializada.");
            System.exit(1);
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
