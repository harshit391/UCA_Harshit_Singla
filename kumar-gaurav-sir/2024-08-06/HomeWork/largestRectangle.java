import java.util.*;

class largestRectangle 
{
    public static int largestRectangleArea(int[] heights) 
    {
        
        Stack<int[]> st = new Stack<>();

        int maxArea = 0;

        int n = heights.length;

        for (int i = 0; i < n; i++)
        {
            if (st.isEmpty() || heights[i] > st.peek()[1])
            {
                st.push(new int[] {i, heights[i]});
            }
            else 
            {
                int minIndex = i;

                while (!st.isEmpty() && heights[i] <= st.peek()[1])
                {
                    int[] rect = st.pop();

                    minIndex = rect[0];

                    maxArea = Math.max(maxArea, rect[1] * (i - rect[0]));
                }

                st.push(new int[] {minIndex, heights[i]});
            }
        }

        while (!st.isEmpty())
        {
            int[] rect = st.pop();

            maxArea = Math.max(maxArea, rect[1] * (n - rect[0]));
        }

        return maxArea;
    }

    public static void testCases()
    {
    	int[] arr1 = {2, 1, 5, 6, 2, 3};

	int[] arr2 = {2, 4};

	assert(largestRectangleArea(arr1) == 10);
	assert(largestRectangleArea(arr2) == 4);

	System.out.println("All Test Cases Passed\n");
    }

    public static void main(String[] args) 
    {
    	testCases();
    }
}
