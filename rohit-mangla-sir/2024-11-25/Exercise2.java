import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", null, "Rohit", null);

        // Exercise 2 :- Change All The Names to Upper Case

        // All the Answers Below Give the Same Result

        // Without Filtering Null Values

//        List<String> res =
//                names.stream().
//                map((name) -> name.toUpperCase()).
//                collect(Collectors.toList());

//        List<String> res =
//                names.stream().
//                map((name) -> return name.toUpperCase()).
//                collect(Collectors.toList());

        // :: is called Method Reference Operator

//        List<String> res =
//                names.stream().
//                map(String::toUpperCase).
//                collect(Collectors.toList());


        // Filter The Null Values Too

//        List<String> res =
//                names.stream().
//                filter((name) -> name != null).
//                map(String::toUpperCase).
//                collect(Collectors.toList());

        List<String> res =
                names.stream().
                filter(Objects::nonNull).
                map(String::toUpperCase).
                collect(Collectors.toList());

        System.out.println(res);
    }
}
