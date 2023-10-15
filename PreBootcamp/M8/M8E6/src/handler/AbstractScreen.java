package handler;

import handler.screen.util.ConsoleUtil;
import handler.screen.util.ScreenOption;

public abstract class AbstractScreen {

    private final boolean BEFORE_SCREEN;
    private final AbstractScreen AFTER_SCREEN;

    private final ScreenOption[] OPTIONS;
    private final String HEADER;

    private String description;

    public AbstractScreen(String header, ScreenOption[] options, boolean before, AbstractScreen after) {
        this.BEFORE_SCREEN = before;
        this.AFTER_SCREEN = after;
        this.OPTIONS = options;
        this.HEADER = header;
    }

    public AbstractScreen(String header, ScreenOption[] options, boolean before) {
        this(header, options, before, null);
    }

    public AbstractScreen(String header, ScreenOption[] options) {
        this(header, options, false, null);
    }

    public AbstractScreen(String header, boolean before) {
        this(header, new ScreenOption[0], before, null);
    }

    public AbstractScreen(String header) {
        this(header, new ScreenOption[0], false, null);
    }

    public boolean requestData() {
        return false;
    }

    public void footer() {
    }

    public void end() {
    }

    public void show() {
        this.show(false);
    }

    public void show(boolean exit) {
        do {
            ConsoleUtil.clearScreen();
            System.out.println(this.HEADER);
            if (this.description != null) {
                System.out.println(this.description);
            }

            if (this.hasOptions()) {
                System.out.println();
                if (this.showOptionsAndShouldExit()) {
                    exit = true;
                } else {
                    System.out.println();
                    if (this.endScreen()) {
                        exit = true;
                    }
                }
            } else if (this.endScreen()) {
                exit = true;
            }
        } while (!exit);

        if (this.AFTER_SCREEN != null) {
            this.AFTER_SCREEN.show();
        }
        this.end();
    }

    private boolean endScreen() {
        final boolean EXIT = this.requestData();
        if (!EXIT) {
            this.footer();
        }

        return EXIT;
    }

    public boolean showOptionsAndShouldExit() {
        final String FIRST_OPTION_MESSAGE = !this.BEFORE_SCREEN ? "Salir de la aplicación." : "Volver atrás.";
        System.out.println(" 0. " + FIRST_OPTION_MESSAGE);

        for (int i = 0; i < this.OPTIONS.length; i++) {
            System.out.println(" " + (i + 1) + ". " + this.OPTIONS[i].getName());
        }

        final int OPTION = ConsoleUtil.requestInt("Seleccione una opción: ", 0, this.OPTIONS.length);
        return OPTION == 0 ? true : this.OPTIONS[OPTION - 1].executeAndShouldExit();
    }

    public boolean hasOptions() {
        return this.OPTIONS.length > 0;
    }

    public boolean hasBeforeScreen() {
        return this.BEFORE_SCREEN;
    }

    public AbstractScreen getAfterScreen() {
        return this.AFTER_SCREEN;
    }

    public String getHeader() {
        return this.HEADER;
    }

    public ScreenOption[] getOptions() {
        return this.OPTIONS;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}