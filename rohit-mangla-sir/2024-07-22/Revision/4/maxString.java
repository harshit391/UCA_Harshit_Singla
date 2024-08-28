import java.util.*;

public class maxString
{
	public static void main(String[] args)
	{
		assert(maxSubStr("eceba") == 3);

		assert(maxSubStr("ccaabbb") == 5);

		System.out.println("All Test Cases Passed\n");
	}

	public static int maxSubStr(String k)
	{
		int n = k.length();

		char[] ch = k.toCharArray();

		int start = 0;

		int maxLen = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++)
		{
			map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);

			while (start <= i && map.size() > 2)
			{
				map.put(ch[i], map.get(ch[i])-1);

				if (map.get(ch[i]) == 0)
				{
					map.remove(ch[i]);
				}
			}
			
			maxLen = Math.max(maxLen, i - start + 1);

		}

		return maxLen;
	}
}
