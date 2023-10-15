package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public abstract class AbstractManager<T> {

    private final Map<String, T> VALUES = new HashMap<>();

    public final void register(String name, T value) {
        this.VALUES.put(name, value);
    }

    public final void unregister(String name) {
        this.VALUES.remove(name);
    }

    public final Map<String, T> getValues() {
        return Collections.unmodifiableMap(this.VALUES);
    }

    public final T getValue(String name) {
        return this.VALUES.get(name);
    }

    public final T getValue(String name, T defaultValue) {
        return this.VALUES.getOrDefault(name, defaultValue);
    }

    public final List<T> getFilteredList(Predicate<T> filter) {
        final List<T> FILTERED_VALUES = this.VALUES.values().stream().filter(filter).toList();
        return new ArrayList<>(FILTERED_VALUES);
    }
}
