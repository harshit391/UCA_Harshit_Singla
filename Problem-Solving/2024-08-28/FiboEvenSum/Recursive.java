public class Recursive
{
	private static int fiboSum(int n, int prev1, int prev2)
	{
		int sum = prev1 + prev2;

		if (sum > n)
		{
			return 0; 
		}

		if (sum % 2 == 0)
		{
			return fiboSum(n, prev2, sum) + sum;
		}

		return fiboSum(n, prev2, sum);
	}

	public static void main(String[] args)
	{
		assert(fiboSum(100, 1, 1) == 44);

		System.out.println("All Test Cases Passed");
	}
}
