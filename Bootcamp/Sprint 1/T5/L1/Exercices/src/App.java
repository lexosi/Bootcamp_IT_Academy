
import handler.commands.LsCommand;
import handler.commands.NanoCommand;
import manager.CommandManager;

public class App {

    /*
     * Entrypoint de la Aplicación:
     * Punto de entrada de la aplicación, que se ejecuta en primera instancia.
     * 
     * Disponemos de la variable args[] que consiste en la lista de palabras
     * que colocamos despues del nombre de nuestro archivo en el comando.
     */
    public static void main(String[] args) {

        /* Comprobamos si el usuario no ha escrito una sola palabra */
        if (args.length == 0) {
            System.out.println("No ha especificado un comando.");
            return; /* Acabamos el código para que no siga ejecutandose */
        }

        App.registerCommands();

        /*
         * Si tu intentas accesar un index de array no definido,
         * salta un ArrayIndexOutOfBoundsException que para el código.
         * Por eso colocamos el anterior check de la longitud.
         */
        final String COMMAND = args[0];

        /*
         * Si nuestro mapa de comandos no contiene nuestro comando
         * devolvemos un mensaje de error y paramos el código.
         */
        if (!CommandManager.getCommands().containsKey(COMMAND)) {
            System.out.println("Comando no reconocido.");
            return;
        }

        final String[] ARGS_WITHOUT_COMMAND = new String[args.length - 1];
        System.arraycopy(args, 1, ARGS_WITHOUT_COMMAND, 0, ARGS_WITHOUT_COMMAND.length);
        CommandManager.execute(COMMAND, ARGS_WITHOUT_COMMAND);
    }

    private static final void registerCommands() {
        CommandManager.register(new LsCommand());
        CommandManager.register(new NanoCommand());
    }

}
