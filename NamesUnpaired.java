import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NamesUnpaired {
    public static List<String> names = List.of("Anton", "Bogdan", "Dima", "Filip", "Kostya", "Leonid", "Masha", "Nikolay");

    public static void main(String[] args) {

        String resultIntStream = IntStream.range(0, names.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> index + ". " + names.get(index))
                .collect(Collectors.joining(", "));

        System.out.println(resultIntStream);
    }
}
