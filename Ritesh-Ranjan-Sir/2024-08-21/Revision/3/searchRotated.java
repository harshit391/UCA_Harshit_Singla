import java.util.*;

class searchRotated
{
    public static int search(int[] nums, int target) 
    {
        int start = 0, end = nums.length -1;

        int n = nums.length;

        while (start <= end)
        {
            int mid = start + ( end - start ) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }

            else if (nums[mid] >= nums[start])
            {
                if (target >= nums[start] && target <= nums[mid])
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
}
