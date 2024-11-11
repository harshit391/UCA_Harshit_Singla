import java.util.function.Function;

public class MyFunction {
    public static void main(String[] args) {
        Function<String, Integer> getStringLength = (str) -> {
            return str.length();
        };

        // One More Way to use
        Function<String, Integer> getStringLengthConcise = String::length;

        System.out.println(getStringLength.apply("singla"));
        System.out.println(getStringLengthConcise.apply("singla"));
    }
}
