import java.util.*;

public class searchRotated
{
	public static void main(String[] args)
	{
 	        int[] nums1 = {4,5,6,7,0,1,2};
        	int target1= 0;

        	assert(search(nums1, target1) == 4);

       		int[] nums2 = {4,5,6,7,0,1,2};
        	int target2 = 3;

        	assert(search(nums2, target2) == -1);

        	int[] nums3 = {1}; 
        	int target3 = 0;

        	assert(search(nums3, target3) == -1);

        	System.out.println("All Test Cases Passeed\n");
	}

	public static int search(int[] nums, int target)
	{
		int end = nums.length - 1;

		int partition = findPartition(nums, 0, end);

		if (partition == -1)
			return binarySearch(nums, 0, end, target);

		int index = binarySearch(nums, 0, partition - 1, target);

		if (index == -1)
			return index;

		return binarySearch(nums, partition, end, target);
	}

	public static int binarySearch(int[] nums, int left, int right, int  key)
	{
		if (left >= right)
			return -1;

		int mid = left + (right - left) / 2;

		if (nums[mid] == key)
			return mid;

		if (nums[mid] < key)
			return binarySearch(nums, mid + 1, right, key);

		return binarySearch(nums, left, mid - 1, key);
	}

	public static int findPartition(int[] nums, int left, int right)
	{
		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;

		if (nums[mid] <= nums[0] && nums[mid] < nums[mid - 1])
			return mid;

		if (nums[mid] <= nums[0])
			return findPartition(nums, left, mid - 1);

		return findPartition(nums, mid + 1, right);
	}
}
