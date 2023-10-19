package handler.commands;

import java.io.File;

import handler.Command;
import utils.FileUtils;

public class LsCommand implements Command {
  /*
   * getCommandName: de este comando será: lscommand -> reemplazamos command -> ls
   */

  @Override
  public boolean execute(String[] args) {
    /*
     * Obtenemos el directorio en base al que ha puesto el usuario en caso de
     * tenerlo, y si no, usamos el directorio actual.
     */
    final String DIRECTORY = args.length > 0 ? args[0] : ".";

    /* En java, un File es considerado como archivo y directorio. */
    final File PATH = new File(DIRECTORY);

    if (!PATH.exists()) {
      System.out.println("Has introducido un directorio que no existe.");
      return false;
    }

    if (!PATH.isDirectory()) {
      System.out.println("El directorio introducido refiere a un archivo.");
      return false;
    }

    try {
      final String RESULT = FileUtils.listFiles(PATH);

      if (args.length > 1 && args[1].equals("-f")) {
        final String FILE_NAME = args.length > 2 ? args[2] : "result.txt";
        FileUtils.saveFile(FILE_NAME, RESULT);
        System.out.println("El resultado ha sido guardado en " + FILE_NAME);
      } else {
        System.out.println(RESULT);
      }

      return true;
    } catch (Exception e) {
      System.out.println("Ha ocurrido un error durante la ejecución del comando.");
      e.printStackTrace();
      return false;
    }
  }
}