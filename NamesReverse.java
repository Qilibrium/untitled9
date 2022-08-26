import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NamesReverse {
    public static List<String> names = List.of("Anton", "Dima", "Filip", "Kostya", "Leonid", "Masha", "Nikolay", "Bogdan");

    public static void main(String[] args) {

        String sortedList = names.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining(", "));

        System.out.println(sortedList.toUpperCase());

    }
}

