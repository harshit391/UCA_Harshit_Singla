import java.util.*;

public class ReverseInt
{
	public static void main(String[] args)
	{
		assert(reverse(123) == 321);

		assert(reverse(-391) == -193);

		assert(reverse(1234567890) == 0);

		System.out.println("All Test Cases Passed\n");
	}

	public static int reverse(int n)
	{
		boolean neg = false;

		if (n < 0)
		{
			n = -n;
			
			neg = true;
		}

		int rev = 0;

		while (n > 0)
		{
			if (rev > Integer.MAX_VALUE / 10)
			{
				return 0;
			}

			rev = rev * 10 + ( n % 10 );

			n /= 10;
		}

		return neg ? -rev : rev;
	}
}
