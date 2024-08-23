import java.util.*;

class countSmaller
{
    public static void merge(int[][] arr, int[][] aux, int left, int mid, int right)
    {
        for (int i = left; i <= right; i++)
        {
            aux[i] = arr[i];
        }

        int inversion_count = 0;

        int i = left, j = mid + 1;

        for (int k = left; k <=right ; k++)
        {
            if (i > mid)
            {
                arr[k] = aux[j];
                j++;
            }

            else if (j > right)
            {
                arr[k] = aux[i];
                arr[k][2] += inversion_count;
                i++;
            }

            else if (aux[i][0] <= aux[j][0])
            {
                arr[k] = aux[i];
                arr[k][2] += inversion_count;
                i++;
            }

            else 
            {
                arr[k] = aux[j];
                inversion_count++;
                j++;
            }
        }
    }

    public static void mergeSort(int[][] arr, int[][] aux, int left, int right)
    {
        if (left >= right)
        {
            return;
        }

        int mid = left + (right-left)/2;

        mergeSort(arr, aux, left, mid);
        mergeSort(arr, aux, mid+1, right);
        merge(arr, aux, left, mid, right);
    }

    public static List<Integer> countSmaller(int[] nums) 
    {
        int n = nums.length;
        
        int[][] arr = new int[n][3];
        int[][] aux = new int[n][3];

        for (int i = 0; i < n; i++)
        {
            arr[i][0] = nums[i];
            aux[i][0] = nums[i];

            arr[i][1] = i;
            aux[i][1] = i;
            
            arr[i][2] = 0;
            aux[i][2] = 0;
        }

        mergeSort(arr, aux, 0, n-1);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            ans.add(0);
        }

        for (int[] i : arr)
        {
            ans.set(i[1], i[2]);
        }

        return ans;
    }

    public static void testCases()
    {
    	int[] arr1 = {5, 2, 6, 1};
	int[] expected1 = {2, 1, 1, 0};

	var ans = countSmaller(arr1);

	for (int i = 0; i < 4; i++)
	{
		assert(ans.get(i) == expected1[i]);
	}

	System.out.println("All Test Cases Passed\n");
    }

    public static void main(String[] args)
    {
    	testCases();
    }
}
