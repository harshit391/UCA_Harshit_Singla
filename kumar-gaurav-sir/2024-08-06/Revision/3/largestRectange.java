class largestRectangle 
{
    public int largestRectangleArea(int[] heights) 
    {
        Stack<int[]> st = new Stack<>();

        int maxArea = 0, n = heights.length;

        for (int i = 0; i < n; i++)
        {
            if (st.isEmpty() || st.peek()[1] < heights[i])
            {
                st.push(new int[] {i, heights[i]});
            }
            else
            {
                int minIndex = i;

                while (!st.empty() && st.peek()[1] >= heights[i])
                {
                    int[] rec = st.pop();

                    minIndex = rec[0];

                    maxArea = Math.max(maxArea, rec[1] * (i - rec[0]));
                }

                st.push(new int[] {minIndex, heights[i]});
            }
        }

        while (!st.empty())
        {
            int[] rec = st.pop();

            maxArea = Math.max(maxArea, rec[1] * (n - rec[0]));
        }

        return maxArea;
    }
}
