import java.util.Arrays;
import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Alice", "Bob", "Charlie", "David");

        String res = list.parallelStream().
            peek(val ->

            System.out.println(
            "Thread Working with Value :- " + val + " and Thread Name :- " + Thread.currentThread().getName())
            ).

            reduce("", (a, b) -> a + b);

        System.out.println(res);
    }
}
