/*
Find the maximum length substring containing at most 2 distinct characters

Example -

S = “eceba”

Ans = 3

Explanation: - “ece” has at most 2 distinct character 
e and c and is the largest substring with the fulfilled conditions
*/

import java.util.*;

class ques{
	private static int lengthOfLongest(String s) {
		int[] freq = new int[128];

		int unique = 0;
		int start = 0;

		int maxlen = 0;

		char[] ch = s.toCharArray();
		
		int n = ch.length;

		for (int i=0; i<n; i++) {
			if (freq[ch[i]] == 0) {
				unique++;
			}
			freq[ch[i]]++;

			while (unique > 2 && start <= i) {
				freq[ch[start]]--;
				if (freq[ch[start]] == 0) {
					unique--;
				}
				start++;
			}
			maxlen = Math.max(maxlen, i-start+1);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		
		System.out.println(lengthOfLongest("eceba"));

	}
}
