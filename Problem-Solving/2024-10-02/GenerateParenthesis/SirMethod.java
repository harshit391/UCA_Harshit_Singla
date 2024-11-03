import java.util.*;

public class SirMethod
{
	@SuppressWarnings("unchecked")
	public static List<String> generate(int n)
	{
		ArrayList<String>[] dp = new ArrayList[n + 1];
		
		dp[0] = new ArrayList<>();

		dp[0].add("");

		dp[1] = new ArrayList<>();

		dp[1].add("()");

		for (int i = 2; i <= n; i++)
		{
			dp[i] = new ArrayList<>();

			for (int j = 0; j < i; j++)
			{
				for (String s : dp[j])
				{
					for (String sub : dp[i - j - 1])
					{
						dp[i].add("(" + s + ")" + sub);
					}
				}
			}
		}

		return dp[n];	
	}
	
	public static boolean testCaseCheck(int n, String[] exp)
	{
		List<String> ans = generate(n);

		List<String> expected = new ArrayList<>();

		for (String i : exp)
			expected.add(i);

		for (String i : ans)
		{
			if (!expected.contains(i))
			{
				return false;
			}
		}

		ans = null;
		expected = null;

		return true;
	}

	public static void main(String[] args)
	{
		assert(testCaseCheck(3, new String[] {"((()))","(()())","(())()","()(())","()()()"}));
		assert(testCaseCheck(1, new String[] {"()"}));

		System.out.println("All Test Cases Passed");
	}
}
