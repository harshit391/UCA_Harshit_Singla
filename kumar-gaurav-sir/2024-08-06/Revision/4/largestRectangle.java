import java.util.*;

class largestRectangle 
{
    public static int largestRectangleArea(int[] heights) 
    {
        int n = heights.length;

        Stack<int[]> st = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i < n; i++) 
        {
            if (st.isEmpty() || heights[i] > st.peek()[1])
            {
                st.push(new int[] {i, heights[i]});
            }
            else 
            {
                int minIndex = i;

                while (!st.isEmpty() && st.peek()[1] >= heights[i])
                {
                    int[] peek = st.pop();

                    minIndex = peek[0];

                    int currAr = (peek[1])*(i - peek[0]);

                    maxArea = Math.max(currAr, maxArea);
                }

                st.push(new int[] {minIndex, heights[i]});
            } 
        }   

        while (!st.isEmpty())
        {
            int[] peek = st.pop();

            int currAr = (peek[1])*(n - peek[0]);

            maxArea = Math.max(maxArea, currAr);
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
     	assert(largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}) == 10);
   	assert(largestRectangleArea(new int[] {2, 4}) == 4);
     	assert(largestRectangleArea(new int[] {6, 2, 5, 4, 5, 1, 6}) == 10);
   	assert(largestRectangleArea(new int[] {7, 2, 8, 9, 1, 3, 6, 5}) == 10);

	System.out.println("All Test Cases Passed");

    }
}
