import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commands;

    private Undo() {
        commands = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void undoCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    public List<String> getHistory() {
        return new ArrayList<>(commands);
    }
}