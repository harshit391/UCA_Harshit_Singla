import java.util.*;

public class groupString
{
	public static void main(String[] args)
	{
		String[] strings  = {"abc","bcd","acef","xyz","az","ba","a","z"};

		var ans = group(strings);

		System.out.println(ans);
	}

	public static List<List<String>> group(String[] arr)
	{
		List<List<String>> res = new ArrayList<>();

		Map<String, List<String>> mp = new HashMap<>();

		for (String s : arr)
		{
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i < s.length(); i++)
			{
				int space = s.charAt(i) - s.charAt(i - 1);

				sb.append(space <  0 ? space + 26 : space);

				sb.append(",");
			}

			String key = sb.toString();

			if (!mp.containsKey(key))
			{
				mp.put(key, new ArrayList<>());
			}

			mp.get(key).add(s);
		}

		for (var i : mp.values())
		{
			res.add(i);
		}

		return res;

	}
}
