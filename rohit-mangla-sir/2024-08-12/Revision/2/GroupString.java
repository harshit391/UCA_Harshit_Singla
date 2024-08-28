import java.util.*;

public class GroupString
{
	public static void main(String[] args)
	{
		String[] arr1 = {"abc","cd","acef","xyz","az","ba","a","z"};

		var list = groupString(arr1);

		System.out.println(list);

	}

	public static List<List<String>> groupString(String[] arr)
	{
		
		List<List<String>> ans = new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String s : arr)
		{
			StringBuilder sb = new StringBuilder();

			for (int i = 1; i < s.length(); i++)
			{
				int space = s.charAt(i) - s.charAt(i-1);

				sb.append(space < 0 ? space + 26 : space);
				
				sb.append(",");
			}

			String key = sb.toString();

			if (!map.containsKey(key))
			{
				map.put(key, new ArrayList<>());
			}

			map.get(key).add(s);
		}

		for (List<String> i : map.values())
		{
			ans.add(i);
		}

		return ans;
	}
}
