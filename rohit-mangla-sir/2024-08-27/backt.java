public class backt
{
	public static int helper(int[][] matrix, int i, int j, int m, int n)
	{
		if (i >= m || j >= n)
		{
			return 0;
		}

		if (i == m - 1 && j == n - 1)
		{
			return matrix[i][j];
		}

		int down = helper(matrix, i + 1, j, m, n);

		int right = helper(matrix, i, j + 1, m, n);

		return Math.max(down, right) + matrix[i][j];
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

		int ans = helper(matrix, 0, 0, 4, 4);

		System.out.println(ans);
	}
}
