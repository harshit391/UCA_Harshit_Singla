import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Exercise 1 -> Filter Elements from The List with First Letter 'A'

        List<String> list = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // First we Create Stream
        // Second We Use Filter which takes a Predicate Lambda
        // Third We Collect the Result Stream into List<String> using Collectors

        List<String> res = list.stream().filter(
                (name) -> name.charAt(0) == 'A'
        ).collect(Collectors.toList());

        System.out.println(res);
    }
}
