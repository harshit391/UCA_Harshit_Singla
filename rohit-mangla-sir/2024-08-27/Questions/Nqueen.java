package Questions;

import java.util.*;

public class Nqueen
{
    static List<List<String>> ans;

    public static void convert(int[][] board)
    {
        int n = board.length;

        List<String> curr = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 1)
                row.append("Q");

                else row.append(".");
            }
            curr.add(new String(row));
        }

        ans.add(curr);
    }

    public static boolean check(int[][] board, int r, int c)
    {
        int n = board.length;

        for (int i = 0; i < n; i++)
        {
            if (board[i][c] == 1)
            {
                return false;
            }
        }

        int maxLeft = Math.min(r, c);

        for (int i = 0; i <= maxLeft; i++)
        {
            if (board[r-i][c-i] == 1)
            {
                return false;
            }
        }

        int maxRight = Math.min(r, board.length - c - 1);

        for (int i = 0; i <= maxRight; i++)
        {
            if (board[r - i][c + i] == 1)
            {
                return false;
            }
        }

        return true;
    }

    public static void solve(int i, int[][] board)
    {
        int n = board.length;

        if (i == n)
        {
            convert(board);
            return;
        }

        for (int j = 0; j < n; j++)
        {
            if (check(board, i,  j))
            {
                board[i][j] = 1;
                solve(i + 1, board);
                board[i][j] = 0;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) 
    {
        int[][] board = new int[n][n];

        ans = new ArrayList<>();
        
        solve(0, board);

        return ans;
    }

    public static void main(String[] args)
    {
        List<List<String>> ans = Nqueen.solveNQueens(4);

        System.out.println(ans);
    }
}