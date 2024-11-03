public class ReverseInteger
{
	public static int reverse(int x)
	{
		int rev = 0;

       	 	while (x != 0)
        	{
            		int rem = x % 10;

            		if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
           		{
                		return 0;
            		}

           		 rev = rev * 10 + rem;
            
            		x /= 10;
        	}

        	return rev;
	}

	public static void main(String[] args)
	{
		assert(reverse(123) == 321);
		assert(reverse(-123) == -321);
		assert(reverse(120) == 21);

		System.out.println("All Test Cases Passed");
	}
}
