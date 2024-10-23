class Reverse 
{
    	public static int reverse(int x) 
    	{
        
        	boolean neg = false;

        	if (x < 0)
        	{
            		x = -x;
            		neg = true;
        	}

        	int rev = 0;

        	while (x > 0)
        	{
            		int rem = x % 10;

            		if (rev > Integer.MAX_VALUE / 10)
            		{
                		return 0;
            		}

            		rev = rev * 10 + rem;

            		x /= 10;
        	}

        	if (neg)
       		{
            		return -rev;
        	}

        	return rev;
    	}

 	public static void main(String[] args)
	{
		assert(reverse(-123) == -321);

		assert(reverse(3456321) == 1236543);

		assert(reverse(1234567890) == 0);

		System.out.println("All Test Cases Passes\n");
	}
}
