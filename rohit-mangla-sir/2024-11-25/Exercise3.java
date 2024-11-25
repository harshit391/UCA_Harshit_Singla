import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Exercise3 {

    public static void main(String[] args) {

        // Exercise 3 Part 1 :- Combine The List of String Elements into Single String

//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", null, "Rohit", null);

//        String result = names.stream().
//                filter(Objects::nonNull).
//                reduce("", (a, b) -> a + b);
//         I am saying that My Result string start with "" and then Combine String 1 and 2
//         So That If the steam is Empty Just return "" to me

//        System.out.println(result);

        // Optional is wrapper class
//        Optional<String> result = names.stream().
//                filter(Objects::nonNull).
//                reduce((a, b) -> a + b);

//        System.out.println(result.isPresent() ? result.get() : "");
//        System.out.println(result.orElse(""));

        // So It's Always Recommended To Use Default Value not Optionals

        // Exercise 3 Part 2 :- Sum of all the Elements in the List Integer

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        Integer result =
//                numbers.stream().
//                filter(Objects::nonNull).
//                reduce(0, (a, b) -> a + b);

        Integer result =
                numbers.stream().
                filter(Objects::nonNull).
                reduce(0, Integer::sum);

        System.out.println(result);

    }
}
