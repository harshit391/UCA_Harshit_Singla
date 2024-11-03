import java.util.*;

public class LargestRectangleInHistogram
{
	public static int largestRectangle(int[] heights)
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

	public static void main(String[] args)
	{
		assert(largestRectangle(new int[] {2, 1, 5, 6, 2, 3}) == 10);
		assert(largestRectangle(new int[] {2, 4}) == 4);

		System.out.println("All Test Cases Passed");
	}
}
