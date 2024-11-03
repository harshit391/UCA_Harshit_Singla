import java.util.*;

public class SortVowels
{
	public static boolean isVowel(char s)
	{
		return (s == 'e' || s == 'E' || s == 'o' || s == 'O' || s == 'U' || s == 'u' || s == 'i' || s == 'I' || s == 'a' || s == 'A');
	}

	public static String sortVowel(String s)
	{
		char[] ch = s.toCharArray();

		List<Character> list = new ArrayList<>();

		for (char k : ch)
		{
			if (isVowel(k))
			{
				list.add(k);
			}
		}

		Collections.sort(list);

		int n = ch.length, idx = 0;

		for (int i = 0; i < n; i++)
		{
			if (isVowel(ch[i]))
			{
				ch[i] = list.get(idx);
				idx++;
			}
		}

		return new String(ch);
	}

	public static void main(String[] args)
	{
		assert(sortVowel("lEetcOde").compareTo("lEOtcede") == 0);
		assert(sortVowel("lYmpH").compareTo("lYmpH") == 0);

		System.out.println("All Test Cases Passed");
	}
}
