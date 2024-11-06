import java.util.function.*;

public class Prime
{
	public static void main(String[] args)
	{
		Predicate<Integer> predicate = (num) ->
		{
			if (num < 0)
			{
				num = -num;
			}

			if (num == 1 || num == 0)
			{
				return false;
			}

			for (int i = 2; i * i <= num; i++)
			{
				if (num % i == 0)
				{
					return false;
				}
			}

			return true;
		};

		System.out.println(predicate.test(3));
		System.out.println(predicate.test(9));
		System.out.println(predicate.test(1));
		System.out.println(predicate.test(17));
	}
}
