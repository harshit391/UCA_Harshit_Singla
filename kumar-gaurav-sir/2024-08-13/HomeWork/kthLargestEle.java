import java.util.*;

class kthLargestEle
{
    static Random rand;

    public static int quickSelect(List<Integer> nums, int k)
    {
        int idx = rand.nextInt(nums.size());

        int pivot = nums.get(idx);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        for (int i : nums)
        {
            if (i > pivot) left.add(i);

            else if (i < pivot) right.add(i);

            else mid.add(i);
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

        for (int i : nums) arr.add(i);

        return quickSelect(arr, k);
    }

    public static void testCases()
    {
    	int[] arr1 = {3, 2, 1, 5, 6, 4};

	int k1 = 2;

	int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

	int k2 = 4;

	assert(findKthLargest(arr1, k1) == 5);
	assert(findKthLargest(arr2, k2) == 4);

	System.out.println("All Test Cases Passed\n");
    }

    public static void main(String[] args)
    {
    	testCases();
    }
}
