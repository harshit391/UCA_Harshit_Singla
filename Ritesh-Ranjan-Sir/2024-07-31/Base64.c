#include <stdio.h>
#include <string.h>
#include <math.h>
#include <assert.h>
#include <stdlib.h>

int convert(int * arr, int start) {
	
	printf("\nConverting from index :- %d\n", start);
	int max = 6;

	int ans = 0;
		
	for (int i = 0; i < 6; i++) {
	
		int shift = max - i - 1;
		printf("Iteration :- %d\n", i);
		printf("Shift :- %d\n", shift);
		printf("Curr Arr :- %d\n", arr[start]);
		int val = ((arr[start++] << shift));

		printf("Value :- %d\n", val);

		ans = (ans | val);

		printf("Answer :- %d\n", ans);
	}

	return ans;
}

void encode(int * arr, int n) {
	
	int len = 8 * n;

	int padding = len % 6;

	printf("%d\n", len);
	printf("%d\n", padding);

	int * res = (int *) malloc (len * sizeof(len));
	
       	int j = 0;

	for (int k = 0; k < n; k++) {
	
		for (int i = 7; i >= 0; i--) {
			res[j++] = (arr[k]&1);
			arr[k] = arr[k] >> 1;
		}
	}

	int req = len/6;

	printf("Req :- %d\n", req);

	for (int i = 0; i < len; i+=8) {
		for (int j =i; j < i + 8; j++) {
			printf("%d ", res[j]);
		}
		printf("\n");
	}

	int * ans = (int *) malloc (req * sizeof(int));
	
	int idx = 0;

	
	for (int i = 0; i < req; i++) {
		ans[idx++] = convert(res, i*6);
	}

	for (int i = 0; i < req; i++) {
		printf("%d ", ans[i]);
	}
	printf("\n");

}

int main() {

	char * in = (char *) malloc (100 * sizeof(char));
	
	scanf("%[^\n]%*c", in);

	int n = strlen(in);

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {

		arr[i] = (int)in[i];
		printf("%d ", arr[i]);
	}
	printf("\n");
	
	printf("%d\n", n);
	printf("%s\n", in);
	
	printf("\nEncoding Starts : -\n");

	encode(arr, n);

	return 0;
}
