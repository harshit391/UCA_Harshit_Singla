package Class;

import java.util.function.Function;

public class TrimString {
    public static void main(String[] args) {

        Function<String, String> trim = (p1) -> {

            int n = p1.length();

            int start = 0, end = n - 1;

            while (start < n && p1.charAt(start) == ' ')  start++;
            while (end >= start && p1.charAt(end) == ' ') end--;

            return p1.substring(start, end + 1);
        };

        System.out.println(trim.apply("    Hello World   "));
        System.out.println(trim.apply(" Hello World              "));
        System.out.println(trim.apply("Hello World"));
    }
}
