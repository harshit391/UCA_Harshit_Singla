public class Iterative
{
	private static int fiboSum(int n)
	{
		int a = 1;
		int b = 1;
		int c = a + b;
		int sum = 0;

		while (c < n)
		{
			if (c % 2 == 0)
				sum += c;
			
			a = b;
			b = c;
			c = a + b;
		}

		return sum;
	}

	public static void main(String[] args)
	{
		assert(fiboSum(100) == 44);

		System.out.println("All Test Cases Passed");
	}
}
