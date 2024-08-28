import java.util.*;
 
public class MaximumRectangle
{
 	public static void main(String[] args)
 	{
		char[][] matrix = 
		{
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'},
		};

		int ans = maximumRectangle(matrix);

		assert(ans == 6);

		System.out.println("Test Cases Passed\n");
	}

	public static int maximumRectangle(char[][] matrix)
	{
		int m = matrix.length, n = matrix[0].length;

		int[] rectangle = new int[n];

		int maxRect = 0;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				rectangle[j] += (matrix[i][j] == '1') ? 1 : 0;
			}

			maxRect = Math.max(maxRect, largestRectangle(rectangle));
		}

		return maxRect;
	}

	public static int largestRectangle(int[] arr)
	{
		Stack<int[]> st = new Stack<>();

		int n = arr.length;

		int maxLen = 0;

		for (int i = 0; i < n; i++)
		{
			if (st.isEmpty() || st.peek()[1] <= arr[i])
			{
				st.push(new int[] {i, arr[i]});
			}
			else 
			{
				int minIndex = i;

				while (!st.isEmpty() && st.peek()[1] > arr[i])
				{
				
					int[] curr = st.pop();

					minIndex = curr[0];

					int area = (i - curr[0]) * curr[1];

					maxLen = Math.max(area, maxLen);
				}

				st.push(new int[] {minIndex, arr[i]});
			}
		}

		while (!st.isEmpty())
		{
			int[] curr = st.pop();

			int area = (n - curr[0]) * curr[1];

			maxLen = Math.max(area, maxLen);
		}

		return maxLen;
	}
}
