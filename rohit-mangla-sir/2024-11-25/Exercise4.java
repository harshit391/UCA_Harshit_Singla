import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exercise4 {

    public static void main(String[] args) {

        // Exercise 4 :- Group the Elements of the List by Key of their First Character

        // A -> {Alice, Arigatou}

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", null, "Arigatou", null, "Baka", "Chinchi", "Daijoubu");

        // Grouping based on some character or some condition we want

        // Like Group the Strings based

        Map<Character, List<String>> res = names.stream().
                filter(Objects::nonNull).
                collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(res);

        // Exercise 4 Part 2 :- Grouping The Elements And Mapping their Values by their Count of Occurence in List

        List<String> countNames = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice", "Bob", "Charlie", "David");

        Map<String, Long> res2 = countNames.stream().
                collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        System.out.println(res2);

    }
}
