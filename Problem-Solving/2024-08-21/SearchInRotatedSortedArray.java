import java.util.*;

public class SearchInRotatedSortedArray
{
	public static int search(int[] nums, int target)
    	{
        	int n = nums.length;

        	int start = 0;
        	int end = n - 1;

        	while (start <= end)
        	{
            		int mid = start + (end - start) / 2;

            		if (nums[mid] == target)
            		{
                		return mid;
            		}

            		if (nums[mid] >= nums[start])
            		{
                		if (target <= nums[mid] && target >= nums[start])
                		{
                    			end = mid - 1;
               			}
                		else
                		{
                    			start = mid + 1;
                		}
            		}
            		else
            		{
                		if (target >= nums[mid] && target <= nums[end])
                		{
                    			start = mid + 1;
                		}
                		else
               		 	{
                    			end = mid - 1;
                		}
            		}
        	}

        	return -1;
    	}


	public static void main(String[] args)
	{
		int[] arr1 = {4,5,6,7,0,1,2};
		int[] arr2 = {4,5,6,7,0,1,2};

		int target1 = 0, target2 = 3;

		assert(search(arr1, target1) == 0);
		assert(search(arr2, target2) == 3);

		System.out.println("All Test Cases Passed");
	}
}
