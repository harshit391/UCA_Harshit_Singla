import java.util.*;

public class Candy
{
	public static void main(String[] args)
	{
		int[] r1 = {1, 0, 2};

		int[] r2 = {1, 2, 2};

		assert(candy(r1) == 5);

		assert(candy(r2) == 4);

		System.out.println("All Test Cases Passed\n");
	}

	public static int candy(int[] ratings)
	{
		int n = ratings.length;

		int[] ans = new int[n];

		Arrays.fill(ans, 1);

		for (int i = 1;  i < n; i++)
		{
			if (ratings[i] > ratings[i - 1])
			{
				ans[i] = ans[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--)
		{
			if (ratings[i] > ratings[i + 1])
			{
				ans[i] = Math.max(ans[i + 1] + 1, ans[i]);
			}
		}

		int count = 0;

		for (int i : ans)
			count += i;

		return count;
	}
}
