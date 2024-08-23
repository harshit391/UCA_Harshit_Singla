public int singleNumber(int[] nums) 
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
                ans |= curr;
            }
        }

        return ans;
}
