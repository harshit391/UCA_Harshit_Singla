import java.util.*;

public class fibo
{
	public static void main(String[] args)
	{
		int a = 1, b = 1;

		int c = a + b;
	
		long count = 0;

		while (c < 100)
		{
			if (c % 2 == 0)
			{
				count += c;
			}

			a = b;
			b = c;
			c = a + b;
		}

		System.out.println(count);
	}
}
