package Class;

import java.util.function.Function;

public class Uppercase {
    public static void main(String[] args) {
        Function<String, String> uppercase = (p1) -> {
            char[] arr = p1.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 'a' && arr[i] <= 'z') arr[i] = (char)(arr[i] - 32);
            }

            return new String(arr);
        };

        System.out.println(uppercase.apply("singla"));
        System.out.println(uppercase.apply("pReeT"));
        System.out.println(uppercase.apply("bEHal"));

    }
}
