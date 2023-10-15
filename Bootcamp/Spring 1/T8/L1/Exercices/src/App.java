
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        // Exercise 1
        final List<String> WORDS = List.of("hello", "world", "java", "python");
        App.printWordsThatContainsLetterO(WORDS);

        // Excercise 2
        final List<String> WORDS_WITH_O = App.returnWordsThatContainsLetterO(WORDS);
        WORDS_WITH_O.forEach(System.out::println);

        // Exercise 3
        final List<String> MONTHS = List.of("January", "February", "March",
                "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        MONTHS.stream().forEach(month -> System.out.println(month));

        // Exercise 4
        MONTHS.stream().forEach(System.out::println); // method reference

        // Exercise 5
        final InterfacePI PI = () -> 3.1415;
        System.out.println(PI.getPiValue());
        // Exercise 6
        final List<Object> LIST = List.of("hello", 2, 5, "something");
        LIST.stream()
                .filter(object -> object instanceof String)
                .map(object -> (String) object)
                .sorted((a, b) -> a.length() - b.length())
                .forEach(System.out::println);

        // Exercise 7
        LIST.stream()
                .filter(object -> object instanceof String)
                .map(object -> (String) object)
                .sorted((a, b) -> b.length() - a.length())
                .forEach(System.out::println);

        // Exercise 8
        final IReverse REVERSE = string -> new StringBuilder(string).reverse().toString();
        System.out.println(REVERSE.reverse("hola"));
    }

    private static final void printWordsThatContainsLetterO(List<String> words) {
        words.stream().filter(word -> word.contains("o")).forEach(System.out::println);
    }

    private static final List<String> returnWordsThatContainsLetterO(List<String> words) {
        return words.stream()
                .filter(word -> word.contains("o"))
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
    }
}

@FunctionalInterface
interface InterfacePI {
    double getPiValue();
}

@FunctionalInterface
interface IReverse {
    String reverse(String value);
}
