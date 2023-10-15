import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class E2 {
    public static void main(String[] args) throws Exception {
        final List<Integer> NUMBERS = new ArrayList<>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
            }
        };

        final List<Integer> NUMBERS_REVERSED = new ArrayList<>();
        final ListIterator<Integer> ITERATOR = NUMBERS.listIterator(NUMBERS.size());
        while (ITERATOR.hasPrevious()) {
            NUMBERS_REVERSED.add(ITERATOR.previous());
        }
    }
}
