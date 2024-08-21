import java.util.*;

public class peakIndex
{
	
	public static int giveIndex(int[] arr) 
	{
		int n = arr.length;

		int start = 0, end = arr.length - 1;

		while (start <= end)
		{
			
			int mid = start + (end - start) / 2;

			if (mid - 1 >= 0 && mid + 1 < n && arr[mid+1] < arr[mid] && arr[mid-1] < arr[mid]) 
			{
				return mid;
			}	
			else if (mid - 1 >= 0 && arr[mid-1] > arr[mid]) 
			{
				end = mid - 1;
			}
			else 
			{
				start = mid + 1;
			}
		}

		return start;
	}

	public static void main(String[] args) 
	{
		int[] arr1 = {0, 1, 0};

		int[] arr2 = {0, 2, 1, 0};

		int[] arr3 = {0, 10, 5, 2};

		assert(giveIndex(arr1) == 1);
		assert(giveIndex(arr2) == 1);
		assert(giveIndex(arr3) == 1);

		System.out.println("All Test Cases Passed\n");
	}
}
