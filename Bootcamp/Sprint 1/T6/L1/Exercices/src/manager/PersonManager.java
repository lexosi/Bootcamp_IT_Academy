package manager;

import handler.Person;

public abstract class PersonManager extends AbstractManager<Person> {
    public static final PersonManager INSTANCE = new PersonManager() {
    };
}
