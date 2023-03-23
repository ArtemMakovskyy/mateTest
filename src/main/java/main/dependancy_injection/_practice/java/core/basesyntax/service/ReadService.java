package main.dependancy_injection._practice.java.core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface ReadService {
    List<String> read(File path);
}
