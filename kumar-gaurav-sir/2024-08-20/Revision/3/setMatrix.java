class Solution 
{
    public void setZeroes(int[][] matrix) 
    {
        int n = matrix.length;

        int m = matrix[0].length;

        int[] rows = new int[n];

        int[] cols = new int[m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (matrix[i][j] == 0)
                {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }        

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (rows[i] == 1 || cols[j] == 1)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
