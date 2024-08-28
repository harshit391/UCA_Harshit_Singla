import java.util.*;

class singleNum 
{
    public static int singleNumber(int[] nums) 
    {
        int[] bits = new int[32];

        for (int i : nums)
        {
            for (int j = 0; j < 32; j++)
            {
                bits[j] += ((i >> j)&1);
            }
        }   

        int ans = 0;

        for (int i = 0; i < 32; i++)
        {
            if (bits[i] % 3 != 0)
            {
                int curr = 1 << i;

                ans = (ans|curr);
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {2, 2, 3, 2};

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};

        assert(singleNumber(nums1) == 3);
        assert(singleNumber(nums1) == 99);

        System.out.println("All Test Cases Passed\n");
    }
}
