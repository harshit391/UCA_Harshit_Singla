import java.util.*;

public class MaximalRectangle
{
	private static int largestRectangle(int[] heights)
	{
		int n = heights.length;

		Stack<int[]> st = new Stack<>();
		
		int maxArea = 0;

		for (int i = 0; i < n; i++)
		{
			if (st.isEmpty() || st.peek()[1] < heights[i])
			{
				st.push(new int[] {i, heights[i]});
			}
			else
			{
				int minIdx = i;
				while (!st.isEmpty() && st.peek()[1] > heights[i])
				{
					int[] curr = st.pop();

					minIdx = curr[0];

					int currArea = (curr[1])*(i - curr[0]);

					maxArea = Math.max(currArea, maxArea);
				}
				st.push(new int[] {minIdx, heights[i]});
			}
		}

		while (!st.isEmpty())
		{
			int[] curr = st.pop();

			int currArea = (curr[1]) * (n - curr[0]);

			maxArea = Math.max(currArea, maxArea);
		}

		return maxArea;
	}

	private static int maxRectangle(char[][] matrix)
	{
		int m = matrix.length, n = matrix[0].length;

		int[] arr = new int[n];

		int maxRec = 0;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				arr[j] += (matrix[i][j] - '0');	
			}
			
			int currRect = largestRectangle(arr);

			maxRec = Math.max(currRect, maxRec);
		}	

		return maxRec;
	}

	public static void main(String[] args)
	{
		char[][] matrix1 = {
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}
		};

		char[][] matrix2 = {
			{'0'}
		};

		char [][] matrix3 = {
			{'1'}
		};

		assert(maxRectangle(matrix1) == 6);
		assert(maxRectangle(matrix2) == 0);
		assert(maxRectangle(matrix3) == 1);

		System.out.println("All Test Casses Passed");
	}
}
