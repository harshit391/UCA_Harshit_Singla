public class RotateImage
{
	public static void rotate(int[][] matrix)
	{
		int n = matrix.length;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n / 2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}

	public static boolean testCases(int[][] org, int[][] exp)
	{
		rotate(org);

		int n = org.length;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (org[i][j] != exp[i][j])
				{
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		int[][] mat1 = {
			{1,2,3},{4,5,6},{7,8,9}
		};

		int[][] ans1 = {
			{7,4,1},{8,5,2},{9,6,3}
		};

		int[][] mat2 = {
			{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
		};

		int[][] ans2 = {
			{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}
		};

		assert(testCases(mat1, ans1));
		assert(testCases(mat2, ans2));

		System.out.println("All Test Cases Passed");
	}
}
