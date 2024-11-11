package Class;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierInputReturnConsumer {

    public static void main(String[] args) {


        // Supplier Should Generate a Random UUID
        // Consumer will Log (Print) it 10 Times In Interval of Two Seconds

        Function<Supplier<String>, Consumer<String>> func = (sup) -> {

            final String randomId = sup.get();

            Consumer<String> consumer = (supplier) -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + supplier + " "  + randomId);
                }
            };

            return consumer;
        };

        Supplier<String> supplier = () -> {
            return UUID.randomUUID().toString();
        };

        func.apply(supplier).accept("Singla");
    }
}
