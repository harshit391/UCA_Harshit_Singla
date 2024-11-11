import java.util.function.Supplier;

public class MySupplier {

    public static void main(String[] args) {
        Supplier<Integer> randomGenerator = () -> {
            return (int) (Math.random() * 10 + 1);
        };

        System.out.println(randomGenerator.get());
    }
}
