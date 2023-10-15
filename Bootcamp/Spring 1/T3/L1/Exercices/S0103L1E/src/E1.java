import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import handler.Month;

public class E1 {
    public static void main(String[] args) throws Exception {
        final Month ADDED_MONTH = new Month("Agosto");

        final List<Month> MONTHS_LIST = new ArrayList<>() {
            {
                this.add(new Month("Enero"));
                this.add(new Month("Febrero"));
                this.add(new Month("Marzo"));
                this.add(new Month("Abril"));
                this.add(new Month("Mayo"));
                this.add(new Month("Junio"));
                this.add(new Month("Julio"));
                this.add(new Month("Septiembre"));
                this.add(new Month("Octubre"));
                this.add(new Month("Noviembre"));
                this.add(new Month("Diciembre"));
            }
        };
        MONTHS_LIST.add(8, ADDED_MONTH);
        
        final Set<Month> MONTHS_SET = new HashSet<>(MONTHS_LIST);

        MONTHS_SET.add(ADDED_MONTH);
        MONTHS_SET.add(ADDED_MONTH);

        MONTHS_SET.stream().filter(month -> month.getName().equals("Agosto")).forEach(System.out::println);
        
        /* For de la lista */
        for (Month month : MONTHS_LIST) {
            System.out.println(month);
        }

        /* For por índice de la lista */
        for (int i = 0; i < MONTHS_LIST.size(); i++) {
            System.out.println(MONTHS_LIST.toArray()[i]);
        }

        /* Usando un iterator */
        final Iterator<Month> MONTHS_ITERATOR = MONTHS_LIST.iterator();
        while (MONTHS_ITERATOR.hasNext()) {
            System.out.println(MONTHS_ITERATOR.next());
        }

        /* Usando un for each */
        MONTHS_LIST.forEach(System.out::println);


    }
}
