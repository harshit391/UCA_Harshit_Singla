import java.util.*;

class ques2 {

	private static int[][] valid(int[] rowSum, int[] colSum) {
	
		int m = rowSum.length;
		int n = colSum.length;

		int[][] ans = new int[m][n];

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			
			ans[i][j] = Math.min(rowSum[i], colSum[j]);

			rowSum[i] -= ans[i][j];
			colSum[j] -= ans[i][j];

			if (rowSum[i] == 0) {
				i++;
			}

			else {
				j++;
			}
		}

		return ans;

	}

	public static void main(String[] args) {

		int[] rows = new int[] {3, 8};
		int[] cols = new int[] {4, 7};

		int[][] ans = valid(rows, cols);
		
		System.out.println(Arrays.deepToString(ans));
	}



}
