class searchRotated {
    public static int search(int[] nums, int target) 
    {
        
        int start = 0;
        int end = nums.length-1;

        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) 
            {
                return mid;
            }

            else if (nums[mid] >= nums[start]) 
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
    	int x = search(new int [] {2, 2, 2, 3, 3, 1, 1}, 1);

	System.out.println(x);
    }


}
