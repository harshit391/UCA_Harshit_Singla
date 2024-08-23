public void setThat(int[][] matrix, int i, int j) 
{
        int m = matrix.length;

        int n = matrix[0].length;

        for (int k = 0; k < n; k++) 
	{
            if (matrix[i][k] != 0) 
	    {
                matrix[i][k] = i + k + (int)1e6;
            }
        }

        for (int k = 0; k < m; k++) 
	{
            if (matrix[k][j] != 0) 
	    {
                matrix[k][j] = k + j + (int)1e6;
            }
        }
}

public void setZeroes(int[][] matrix) 
{
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) 
	{
            for (int j = 0; j < n; j++) 
	    {
                if (matrix[i][j] == 0) 
		{
                    setThat(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) 
	{
            for (int j = 0; j < n; j++) 
	    {
                if (matrix[i][j] == i + j + (int)1e6) 
		{
                    matrix[i][j] = 0;
                }
            }

        }
}
