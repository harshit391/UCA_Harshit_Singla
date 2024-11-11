package Class;

import java.util.function.Function;

public class SQRT {
    public static void main(String[] args) {
        Function<Integer, Double> sqrt = (p1) -> {
          return Math.sqrt(p1);
        };

        System.out.println(sqrt.apply(4));
        System.out.println(sqrt.apply(256));
        System.out.println(sqrt.apply(46));
        System.out.println(sqrt.apply(391));
    }
}
