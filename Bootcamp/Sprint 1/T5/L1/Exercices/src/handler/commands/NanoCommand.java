package handler.commands;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import handler.Command;

public class NanoCommand implements Command {

  @Override
  public boolean execute(String[] args) throws Exception {
    final File FILE = new File(args[0]);

    if (!FILE.exists()) {
      System.out.println("Has introducido un directorio que no existe.");
      return false;
    }

    if (!FILE.isFile()) {
      System.out.println("No has introducido un archivo correcto.");
      return false;
    }

    final List<String> LINES = Files.readAllLines(FILE.toPath(), StandardCharsets.UTF_8);
    System.out.println(LINES.stream().collect(Collectors.joining("\n")));

    return true;
  }

  @Override
  public int getMinArgs() {
    return 1;
  }
}
