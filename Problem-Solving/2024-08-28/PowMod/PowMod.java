public class PowMod
{
	private static int pow_mod(int x, int y, int n)
	{
		x %= n;

		if (y == 1)
		{
			return x;
		}

		int m = pow_mod(x, y/2, n) % n;

		if (y % 2 == 0)
		{
			return (m * m) % n;
		}

		return (x * m * m) % n;
	}

	public static void main(String[] args)
	{
		assert(pow_mod(2, 10, 7) == 2);
		assert(pow_mod(19, 1987, 71) == 4);

		System.out.println("All Test Cases Passed");
	}
}
