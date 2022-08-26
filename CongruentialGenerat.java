import java.util.stream.Stream;

public class CongruentialGenerat {

    public static void main(String[] args) {
        double seed = 10;
        double a = 25214903917L;
        double m = Math.pow(2, 48);
        double c = 11;

        Stream.iterate(seed, x -> (a * x + c) % m)
                .limit(10)
                .forEach(System.out::println);

    }
}
