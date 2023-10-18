package manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import handler.Command;

public class CommandManager {

  private static final Map<String, Command> COMMANDS = new HashMap<>();

  public static void register(Command command) {
    CommandManager.COMMANDS.put(command.getCommandName(), command);
  }

  public static void unregister(String commandName) {
    CommandManager.COMMANDS.remove(commandName);
  }

  /*
   * Unmodifiable, hace que no se pueda modificar directamente el contenido, si no
   * que tengas que ejecutar de manera obligatoria algun método de este misma
   * clase, ya sea el register o el unregister.
   */
  public static Map<String, Command> getCommands() {
    return Collections.unmodifiableMap(CommandManager.COMMANDS);
  }

  public static boolean execute(String command, String[] args) {
    if (!CommandManager.COMMANDS.containsKey(command)) {
      return false;
    }

    final Command COMMAND = CommandManager.COMMANDS.get(command);

    if (args.length < COMMAND.getMinArgs()) {
      System.out.println("No has introducido la cantidad necesaria de argumentos.");
      return false;
    }

    try {
      return COMMAND.execute(args);
    } catch (Exception e) {
      System.out.println("Ha ocurrido un error durante la ejecución del comando.");
      e.printStackTrace();

      return false;
    }
  }
}
