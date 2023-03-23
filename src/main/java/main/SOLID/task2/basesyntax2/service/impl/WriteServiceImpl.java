package main.SOLID.task2.basesyntax2.service.impl;

import main.SOLID.task2.basesyntax2.service.WriteService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteServiceImpl implements WriteService {
    @Override
    public void write(String content, String path) {
        try {
            Files.writeString(Paths.get(path),content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + path,e);
        }
    }
}
