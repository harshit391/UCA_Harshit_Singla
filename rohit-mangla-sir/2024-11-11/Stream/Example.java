package Stream;

import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(list);

        List<Integer> oddList = list.stream().filter((num) -> {
            return num % 2 != 0;
        }).collect(Collectors.toList());

        System.out.println(oddList);

        List<String> oddNumbers = list.stream().filter((num) -> {
            return num % 2 == 0;
        }).map(num -> {
            return String.valueOf("String :- " + num);
        }).collect(Collectors.toList());

        System.out.println(oddNumbers);
    }
}
