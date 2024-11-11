import java.util.*;

interface IdOdd {
    public void test(Integer a, Integer b, Integer c);
}

public class Lambda implements IdOdd {

    public static void main(String[] args) {
        IdOdd obj = (a, b, c) -> {
            System.out.println(a + " " + b + " " + c);
        };

        obj.test(1, 2, 3);  // Passing integers as arguments
    }

    @Override
    public void test(Integer a, Integer b, Integer c) {

    }
}
