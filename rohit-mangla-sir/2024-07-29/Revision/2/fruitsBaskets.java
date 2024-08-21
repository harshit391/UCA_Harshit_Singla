import java.util.*;

public class fruitsBaskets
{	
	public static int totalFruit(int[] arr)
	{
		int n = arr.length;

		Map<Integer, Integer> map = new HashMap<>();

		int start = 0;

		int fruits = 0;
		int maxFruits = 0;

		for (int i = 0; i < n; i++) 
		{
			
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			fruits++;	

			while (start <= i && map.size() > 2) 
			{
				
				map.put(arr[start], map.get(arr[start]) - 1);
				fruits--;
				if (map.get(arr[start]) == 0) 
				{
					map.remove(arr[start]);
				}	
			}

			maxFruits = Math.max(maxFruits, fruits);
		}

		return maxFruits;
	}	

	public static void main(String[] args)
	{
		int[] arr1 = {1, 2, 1};
		int[] arr2 = {0, 1, 2, 2};
		int[] arr3 = {1, 2, 3, 2, 2};

		assert(totalFruit(arr1) == 3);
		assert(totalFruit(arr2) == 3);
		assert(totalFruit(arr3) == 4);

		System.out.println("All Test Cases Passed\n");
	}
}
