import java.util.*;

public class MyMethod
{
	static List<String> arr;

	private static void helper(StringBuilder sb, int n, int open, int close)
	{
		if (sb.length() == 2*n)
		{
			arr.add(sb.toString());
			return;
		}

		if (open > close)
		{
			sb.append(")");
			helper(sb, n, open, close + 1);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (open < n)
		{
			sb.append("(");
			helper(sb, n, open + 1, close);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static List<String> generate(int n)
	{
		arr = new ArrayList<>();
		
		helper(new StringBuilder(), n, 0, 0);
		
		return arr;	
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
