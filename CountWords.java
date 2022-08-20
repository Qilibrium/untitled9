import java.io.IOException;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

public class CountWords {

    private static final String RELATIVE_PATH = "src/words.txt";

    public static void main(String[] args) throws IOException {


        Map<String, Long> wordCountMap = lines(Path.of(RELATIVE_PATH))
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting()));
        wordCountMap
                .entrySet()
                .forEach(System.out::println);
    }
}






