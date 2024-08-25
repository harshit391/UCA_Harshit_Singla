import java.util.*;

class peakIndex
{
    public int peakIndexInMountainArray(int[] arr)
    {
        if (arr[0] > arr[1])
        {
            return 0;
        }

        int start = 0, end = arr.length - 1, n = arr.length;

        if (arr[n-1] > arr[n-2])
        {
            return n - 1;
        }

        while ( start <= end )
        {
            int mid = start + ( end - start ) / 2;

            if (mid - 1 >= 0 && mid + 1 < n && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
            {
                return mid;
            }

            else if (mid-1 >= 0 && arr[mid] < arr[mid-1])
            {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
