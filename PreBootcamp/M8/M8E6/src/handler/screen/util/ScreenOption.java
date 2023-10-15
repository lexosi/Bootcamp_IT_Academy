package handler.screen.util;

import java.util.function.Supplier;

public class ScreenOption {

    private final String NAME;
    private final Supplier<Boolean> ACTION;

    public ScreenOption(String name, Supplier<Boolean> action) {
        this.NAME = name;
        this.ACTION = action;
    }

    public String getName() {
        return this.NAME;
    }

    public boolean executeAndShouldExit() {
        return this.ACTION.get();
    }
}
