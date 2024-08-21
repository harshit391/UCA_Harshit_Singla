import java.util.*;

public class ValidMatrix
{
	
	public static int[][] restoreMatrix(int[] rowSum, int[] colSum) 
	{
		int m = rowSum.length;
		int n = colSum.length;
		
		int[][] ans = new int[m][n];

		int i = 0;
		int j = 0;

		while (i < m && j < n) 
		{
			
			ans[i][j] = Math.min(rowSum[i], colSum[j]);

			rowSum[i] -= ans[i][j];
			colSum[j] -= ans[i][j];

			if (rowSum[i] == 0)
			{
				i++;
			} 
			else 
			{
				j++;
			}
		}

		return ans;
	}	

	public static void main(String[] args) 
	{
		int[] rowSum1 = {3, 8};
		int[] colSum1 = {4, 7};

		int[] rowSum2 = {5, 7, 10};
		int[] colSum2 = {8, 6, 8};
		
		System.out.println(Arrays.deepToString(restoreMatrix(rowSum1, colSum1)));
		System.out.println(Arrays.deepToString(restoreMatrix(rowSum2, colSum2)));

	}
}
