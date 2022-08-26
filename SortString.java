public class SortString {

    public static String[] str = {"1, 2, 0", "4, 5"};

    public static void main(String[] args) {
        String arrayToString = String.join("", str);
        String numberOnly = arrayToString.replaceAll("[^0-9]", "");

        String result = numberOnly.chars()
                .sorted().filter(Character::isDigit)
                .map(Character::getNumericValue).mapToObj(String::valueOf)
                .reduce((x,y)->x+", "+y).get();

        System.out.println(result);

    }
}
