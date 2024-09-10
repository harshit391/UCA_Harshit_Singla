import java.util.*;

class kthLargest
{
    static Random rand;

    public static int quickSelect(List<Integer> arr, int k)
    {

        int idx = rand.nextInt(arr.size());

        int pivot = arr.get(idx);

        List<Integer> left = new ArrayList<>();
        
        List<Integer> right = new ArrayList<>();

        List<Integer> mid = new ArrayList<>();

        for (int i : arr)
        {
            if (i > pivot)
            {
                left.add(i);
            }
            else if (i == pivot)
            {
                mid.add(i);
            }
            else 
            {
                right.add(i);
            }
        }

        if (k <= left.size())
        {
            return quickSelect(left, k);
        }

        if (left.size() + mid.size() < k)
        {
            return quickSelect(right, k - left.size() - mid.size());
        }

        return pivot;
    }

    public static int findKthLargest(int[] nums, int k) 
    {
        rand = new Random();

        List<Integer> arr = new ArrayList<>();

        for (int i : nums)
        {
            arr.add(i);
        }

        return quickSelect(arr, k);

    }

    public static void main(String[] args)
    {
     	assert(findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2) == 5);
   	assert(findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4);

	System.out.println("All Test Cases Passed\n");
    }
}
