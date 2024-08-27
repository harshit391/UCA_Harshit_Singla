public class backtmin
{
	public static boolean valid(int[][] matrix, int i, int j)
	{
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
			return false;

		return true;
	}

	public static int helper(int[][] matrix, int i, int j)
	{

		int m = matrix.length, n = matrix[0].length;

		if (i == m - 1 && j == n - 1)
		{
			return matrix[i][j];
		}

		boolean choice1 = valid(matrix, i + 1, j);

		boolean choice2 = valid(matrix, i, j + 1);

		if (choice1 && choice2)
		{
			int ch1 = helper(matrix, i + 1, j);

			int ch2 = helper(matrix, i, j + 1);

			return matrix[i][j] + Math.min(ch1, ch2);
		}

		if (choice1)
			return matrix[i][j] + helper(matrix, i + 1, j);

		return matrix[i][j] + helper(matrix, i, j + 1);
	}

	public static void main(String[] args)
	{
		int[][] matrix = 
		{
			{1, 1, 1, 1},
			{1, 1, 1, 1},
			{1, 1, 1, 1},
			{0, 0, 0, 0}
		};

		int ans = helper(matrix, 0, 0);

		System.out.println(ans);
	}
}
