package handler;

public interface Command {

  default String getCommandName() {
    return this.getClass().getSimpleName().toLowerCase()
        .replaceAll("command", "");
  }

  boolean execute(String[] args) throws Exception;

  /* Un comando se compone de: /comando <argumentos> */
  default int getMinArgs() {
    return 0;
  }
}
