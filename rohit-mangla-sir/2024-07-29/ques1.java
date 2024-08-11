import java.util.*;

class ques1 {

	private static int fruit(int[] arr) {
		
		int n = arr.length;

		int start = 0;
		int unique = 0;

		int count = 0;

		int[] freq = new int[n];

		for (int i = 0; i < n; i++) {
			
			if (freq[arr[i]] == 0) {
				unique++;
			}
			freq[arr[i]]++;

			while (unique > 2 && start <= i) {
				
				freq[arr[start]]--;
				
				if (freq[arr[start]] == 0) {
					unique--;
				}
				
				start++;
			}

			count = Math.max(count, i - start + 1);
		}

		return count;
	
	}

	public static void main(String[] args) {
		
		System.out.println(fruit(new int[] {0, 1, 2, 2}));
	}
}
