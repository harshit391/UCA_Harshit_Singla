import java.util.function.*;

class ConsumerExp
{
	public static void main(String[] args)
	{
		Consumer<String> consumer = (p1) -> {
			System.out.println("Value Consumed " + p1);
		};

		consumer.accept("Singla");
		consumer.accept("Behal");
		consumer.accept("Preet");
	}
}
