import java.util.*;

public class lengthOfString
{
	public static int lengthOfString(String s)
	{
		
		char[] ch = s.toCharArray();

		int n = ch.length, start = 0, maxLen = 0;

		int[] freq = new int[26];

		int unique = 0;

		for (int i = 0; i < n; i++)
		{
			int curr = ch[i] - 'a';

			if (freq[curr] == 0)
			{
				unique++;
			}
			freq[curr]++;

			while (start <= i && unique > 2)
			{
				int idx = ch[start] - 'a';

				freq[idx]--;

				if (freq[idx] == 0) 
				{
					unique--;	
				}
				start++;
			}

			maxLen = Math.max(maxLen, i - start + 1);
		}

		return maxLen;
	}

	public static void main(String[] args)
	{
		String s = "eceba";

		assert(lengthOfString(s) == 3);

		System.out.println("Test Cases Passes\n");
	}
}
