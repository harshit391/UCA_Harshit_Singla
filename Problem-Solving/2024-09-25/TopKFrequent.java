import java.util.*;

public class TopKFrequent
{
	public static int[] topElements(int[] arr, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();

		PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

		for (int i : arr)
		{
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			que.add(entry);
			if (que.size() > k)
			{
				que.poll();
			}
		}

		int[] ans = new int[k];

		for (int i = 0; i < k; i++)
		{
			ans[i] = que.poll().getKey();
		}

		return ans;
	}

	public static boolean testCaseCheck(int[] arr, int k, int[] exp)
	{
		List<Integer> set1 = new ArrayList<>();
		List<Integer> set2 = new ArrayList<>();

		int[] ans = topElements(arr, k);

		for (int i : ans)
			set1.add(i);

		for (int i : exp)
			set2.add(i);

		for (int i : set1)
		{
			if (!set2.contains(i))
			{
				return false;
			}
		}

		set1 = null;
		set2 = null;

		return true;
	}

	public static void main(String[] args)
	{
		assert(testCaseCheck(new int[] {1, 1, 1, 2, 2, 3}, 2, new int[] {1, 2}));

		assert(testCaseCheck(new int[] {1}, 1, new int[] {1}));

		System.out.println("All Test Cases Passed");
	}
}
