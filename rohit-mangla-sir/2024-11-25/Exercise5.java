import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exercise5 {

    public static void main(String[] args) {

        // Exercise 5 :- Group All The Elements by Key of their String Length

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Arigatou", "Baka", "Chinchi", "Daijoubu");

        Map<Integer, List<String>> res =
                names.stream().map(String::toLowerCase).
                collect(Collectors.groupingBy(String::length));

        System.out.println(res);

    }
}
