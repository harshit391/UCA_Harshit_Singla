import java.util.*;

public class SmallestK
{
	public static int[] findElements(int[] arr, int k)
	{
		int[] ans = new int[k];

		int n = arr.length;

		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

		for (int i : arr)
		{
			if (que.isEmpty())
			{
				que.add(i);
			}
			else if (que.size() < k)
			{
				que.add(i);
			}
			else
			{
				if (que.peek() > i)
				{
					que.poll();
					que.add(i);
				}
			}
		}

		for (int i = 0; i < k; i++)
		{
			ans[i] = que.poll();
		}

		return ans;
	}

	public static boolean testCasesCheck(int[] arr, int k, int[] res)
	{
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		int[] ans = findElements(arr, k);
		
		for (int i : ans)
		{
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}

		for (int i : res)
		{
			map2.put(i, map2.getOrDefault(i, 0) + 1);
		}

		for (int i : res)
		{
			if (!map1.containsKey(i))
			{
				return false;
			}
			if (map1.get(i) != map2.get(i))
			{
				return false;
			}
		}

		map1 = null;
		map2 = null;

		return true;
	}

	public static void main(String[] args)
	{
		assert(testCasesCheck(new int[] {3, 2, 6, 7, 2, 1, 9}, 3, new int[] {1, 2, 2}));

		System.out.println("All Test Cases Passed");
	}
}
