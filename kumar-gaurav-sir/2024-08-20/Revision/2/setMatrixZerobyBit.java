import java.math.BigInteger;

/*
        Main Intution was to store that particular row and column
        Containing zero in them
        as a bit value
        like row 3 contains 0
        So set Bit Value 1 at position 3 of r
        similaryly do it for column
    */
    public void setZeroes(int[][] matrix) 
    {
        BigInteger r = BigInteger.ZERO, c = BigInteger.ZERO;

        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    r = r.or(BigInteger.ONE.shiftLeft(i));
                    c = c.or(BigInteger.ONE.shiftLeft(j));
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            if (r.testBit(i))
            {
                for (int j = 0; j < n; j++)
                matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < n; j++)
        {
            if (c.testBit(j))
            {
                for (int i = 0; i < m; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
