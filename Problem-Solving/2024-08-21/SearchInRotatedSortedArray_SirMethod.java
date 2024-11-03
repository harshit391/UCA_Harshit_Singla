public class SearchInRotatedSortedArray_SirMethod
{
	public static int findPartition(int[] arr, int start, int end)
	{
		if (start > end)
		{
			return -1;
		}

		int mid = (start + end) >> 1;

		if (arr[mid] <= arr[0])
		{
			if (arr[mid] < arr[mid - 1])
			{
				return mid;
			}
			else
			{
				return findPartition(arr, start, mid - 1);
			}
		}
		
		return findPartition(arr, mid + 1, end);
	}

	public static int binarySearch(int[] arr, int start, int end, int target)
	{
		if (start > end)
		{
			return -1;
		}

		while (start <= end)
		{
			int mid = (start + end) >> 1;

			if (arr[mid] == target)
			{
				return mid;
			}
			else if (arr[mid] > target)
			{
				end = mid - 1;
			}
			else
			{
				start = mid + 1;
			}
		}

		return -1;
	}

	public static int searchRotated(int[] arr, int target)
	{
		int n = arr.length;

		int partIndex = findPartition(arr, 0, n - 1);

		if (partIndex == -1)
		{
			return binarySearch(arr, 0, n - 1, target);
		}

		int leftPart = binarySearch(arr, 0, partIndex - 1, target);

		if (leftPart != -1)
		{
			return leftPart;
		}

		return binarySearch(arr, partIndex, n - 1, target);
	}

	public static void test_search(int[] arr, int key, int exp)
	{
		assert(searchRotated(arr, key) == exp);
	}

	public static void main(String[] args)
	{
		int[] input_array = new int[] {3, 5, 6, 7, 3, 3, 3};
    		
		test_search(input_array, 3, 0);
    		test_search(input_array, 6, 2);
    		test_search(input_array, 9, -1);
    		test_search(input_array, 0, -1);

    		input_array = new int[] {4, 5, 6, 7, 1, 2, 3};

    		test_search(input_array, 3, 6);
    		test_search(input_array, 6, 2);
    		test_search(input_array, 1, 4);
    		test_search(input_array, 9, -1);
    		test_search(input_array, 0, -1);

    		input_array = new int[] {1, 2, 3, 4, 5, 6, 7};

    		test_search(input_array, 3, 2);
    		test_search(input_array, 6, 5);
    		test_search(input_array, 1, 0);
   		test_search(input_array, 7, 6);
    		test_search(input_array, 9, -1);
    		test_search(input_array, 0, -1);

    		input_array = new int[] {1, 1, 1, 1, 1, 1, 1};

    		test_search(input_array, 1, 3);
    		test_search(input_array, 9, -1);
    		test_search(input_array, 0, -1);

		System.out.println("All Test Cases Passed");
	}
}
