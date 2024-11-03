public class FirstMissingPositive
{
	public static int firstPositive(int[] nums)
	{
		int n = nums.length;

		for (int i = 0; i < n;)
		{
			int correct = nums[i] - 1;

			if (nums[i] < n && nums[i] > 0 && nums[correct] != nums[i])
			{
				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			}
			else
			{
				i++;
			}
		}

		for (int i = 0; i < n; i++)
		{
			if (nums[i] != i + 1)
			{
				return i + 1;
			}
		}	

		return n + 1;
	}

	public static void main(String[] args)
	{
		assert(firstPositive(new int[] {1, 2, 0}) == 3);
		assert(firstPositive(new int[] {3, 4, -1, 1}) == 2);
		assert(firstPositive(new int[] {7, 8, 9, 11, 12}) == 1);

		System.out.println("All Test Cases Passed");
	}
}
