class singleNumberII
{
    public int singleNumber(int[] nums) 
    {
        int[] bits = new int[32];

        for (int i : nums) 
        {
            for (int j = 0; j < 32; j++) 
            {
                int curr = ((i >> j)&1);
                bits[j] += curr;
            }
        }    

        int ans = 0;
        for (int i = 0; i < 32; i++) 
        {
            if (bits[i] % 3 != 0) 
            {
                int x = 1 << i;
                ans = (ans|x);
            }
        }

        return ans;
    }
}
