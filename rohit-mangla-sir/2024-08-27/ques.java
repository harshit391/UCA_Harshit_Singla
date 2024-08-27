public class ques
{
	public static void helper(int m, int n, int i, int j)
	{
		if (i == m && j == n)
		{
			System.out.println("Reached the end");
			System.out.println("=============");
			return;
		}

		else if (i > m || j > n)
		{
			return;
		}

		System.out.print(i + " " + j + " => ");

		// down
		helper(m, n, i+1, j);

		// right
		helper(m, n, i, j+1);	
	}

	public static void main(String[] args)
	{
		helper(3, 3, 0, 0);
	}


}
