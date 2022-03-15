package com.github.danielraguiar.servicoanalisedados.processor;


import com.github.danielraguiar.servicoanalisedados.config.PathConfig;
import com.github.danielraguiar.servicoanalisedados.dto.RelatorioDto;
import com.github.danielraguiar.servicoanalisedados.util.FileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;

@Component
public class RelatorioProcessor extends Thread {

    private final InputFileProcessor inputFileProcessor;
    private final OutputFileProcessor outputFileProcessor;

    @Autowired
    public RelatorioProcessor(InputFileProcessor inputFileProcessor, OutputFileProcessor outputFileProcessor) {
        this.inputFileProcessor = inputFileProcessor;
        this.outputFileProcessor = outputFileProcessor;
    }

    private static final Path folder = PathConfig.PATH_IN;

    @Override
    public void run() {

        WatchService watchService;

        try {
            createFolderIfNotExist();
            watchService = FileSystems.getDefault().newWatchService();

            folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                WatchKey key;
                key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    Path path = (Path) event.context();
                    Path fileInPath = Paths.get(String.valueOf(folder), String.valueOf(path.toString()));

                    RelatorioDto dto = inputFileProcessor.processamento(fileInPath);
                    outputFileProcessor.process(dto, fileInPath);

                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createFolderIfNotExist() throws IOException {
        FileUtil.createFolder(PathConfig.PATH_DATA);
        FileUtil.createFolder(PathConfig.PATH_IN);
        FileUtil.createFolder(PathConfig.PATH_OUT);
    }
}
