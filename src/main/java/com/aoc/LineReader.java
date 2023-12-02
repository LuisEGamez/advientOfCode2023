package com.aoc;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LineReader {

  private final @NotNull String filePath;

  public LineReader(@NotNull String filePath) {
    this.filePath = filePath;
  }

  public Stream<String> getLines() {
    try {
      return Files.lines(Paths.get(this.filePath));
    } catch (IOException e) {
      System.out.println("El archivo no existe");
      return null;
    }
  }
}
