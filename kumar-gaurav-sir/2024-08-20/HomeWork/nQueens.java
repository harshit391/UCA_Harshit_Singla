import java.util.*;
import java.util.stream.Collectors;

class nQueens 
{
    static List<List<String>> ans;

    public static void convertBoard(int[][] board)
    {
        List<String> curr = new ArrayList<>();
    
        int n = board.length;    

        for (int i = 0; i < n; i++)
        {
            char[] arr = new char[n];
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 1)
                {
                    arr[j] = 'Q';
                } 
                else
                {
                    arr[j] = '.';
                }
            }
            curr.add(new String(arr));
        }

        ans.add(curr);
    }

    public static boolean checkBoard(int[][] board, int r, int c)
    {
        int n = board.length;

        for (int i = r; i >= 0; i--)
        {
            if (board[i][c] == 1)
            {
                return false;
            }
        }

        for (int i = 1; i <= Math.min(r, c); i++)
        {
            if (board[r-i][c-i] == 1)
            {
                return false;
            }
        }
        
        for (int i = 1; i <= Math.min(r, board.length-c-1); i++)
        {
            if (board[r-i][c+i] == 1) 
            {
                return false;
            }
        }

        return true;
    }

    public static void solve(int [][] board, int row)
    {
        int n = board.length;

        if (row == n)
        {
            convertBoard(board);
            return;
        }

        for (int j = 0; j < n; j++)
        {
            if (checkBoard(board, row, j))
            {
                board[row][j] = 1;
                solve(board, row+1);
                board[row][j] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) 
    {
        int[][] board = new int[n][n];

        ans = new ArrayList<>();

        solve(board, 0);

        return ans;
    }

    public static void main(String[] args)
    {
    	int n = 4;

	System.out.println(solveNQueens(n));
    }
}
