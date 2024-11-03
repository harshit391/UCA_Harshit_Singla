import java.util.Arrays;

public class LonelyNumbers
{
	public static int[] findNumbers(int[] nums)
	{
		int n = nums.length;

		int totalXor = 0;

		for (int i : nums)
		{
			totalXor ^= i;
		}

		int firstSetBit = 1;
		while ((totalXor & firstSetBit) != firstSetBit)
		{
			firstSetBit <<= 1;
		}

		int singleNumber1 = 0;
		int singleNumber2 = 0;

		for (int i : nums)
		{
			if ((i & firstSetBit) == 0)
			{
				singleNumber1 ^= i;
			}
			else
			{
				singleNumber2 ^= i;
			}
		}

		return new int[] {singleNumber1, singleNumber2};
	}

	public static void testCases(int[] arr, int num1, int num2)
	{
		int[] ans = findNumbers(arr);

		assert((ans[0] == num1 && ans[1] == num2) || (ans[0] == num2 && ans[1] == num1));
	}

	public static void main(String[] args)
	{
		testCases(new int[] {1, 2, 1, 3, 2, 5}, 3, 5);
		testCases(new int[] {-1, 0}, -1, 0);
		testCases(new int[] {0, 1}, 1, 0);

		System.out.println("All Test Cases Passed");
	}
}
