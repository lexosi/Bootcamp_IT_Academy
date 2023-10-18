import handler.Person;

public class App {

    public static void main(String[] args) {
        final Person PERSON = new Person("Marcos", "Lopez", 17);

        GenericMethods.printValues(PERSON.getName(), PERSON.getLastName(), PERSON.getAge());
        GenericMethods.printValues(PERSON.getLastName(), PERSON.getName(), PERSON.getAge());
        GenericMethods.printValues(PERSON.getAge(), PERSON.getName(), PERSON.getLastName());
    }
}
