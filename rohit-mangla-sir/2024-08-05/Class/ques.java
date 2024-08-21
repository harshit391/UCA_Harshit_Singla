import java.util.*;

class ques {

	public static int index(int[] arr) {

		int start = 0;
		int end = arr.length - 1;
		int n = arr.length;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (mid -1 >= 0 && mid + 1 < n && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
				return mid;
			}
	
			else if (mid - 1 >= 0 && arr[mid] <= arr[mid-1]) {
				end = mid - 1;
			}

			else {
				start = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		
		int[] arr = new int[] {0, 10, 5, 2};

		System.out.println(index(arr));
	}	

}
