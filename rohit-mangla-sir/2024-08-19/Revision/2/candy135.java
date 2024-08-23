import java.util.*;

class candy135 
{
    public static int candy(int[] ratings) 
    {
        
        int count = 0;

        int n = ratings.length;

        int[] arr = new int[n];

        Arrays.fill(arr, 1);

        for (int i = 1; i < n; i++)
        {
            if (ratings[i] > ratings[i-1])
            {
                arr[i] = arr[i-1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i+1])
            {
                arr[i] = Math.max(arr[i], arr[i+1] + 1);
            }
        }

        for (int i : arr)
        {
            count += i;
        }

        return count;
    }

    public static void main(String[] args) 
    {
    	int[] ratings1 = {1, 0, 2};

	int[] ratings2 = {1, 2, 2};

	assert(candy(ratings1) == 5);
	
	assert(candy(ratings2) == 4);

	System.out.println("All Test Cases Passes\n");	
    }
}
