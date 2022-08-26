import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMix {

    public static void main(String[] args) {
        Stream<String> first = Stream.of("One", "Two", "Three", "Four", "Five");
        Stream<String> second = Stream.of("1", "2", "3", "4", "5", "6");

        Stream<String> result=zip(first,second);
        result.peek(System.out::println).collect(Collectors.toList());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T>result=new ArrayList<>();

        Iterator<T> iteratorFirst= first.iterator();
        Iterator<T> iteratorSecond=second.iterator();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }

        return result.stream();
    }
}
