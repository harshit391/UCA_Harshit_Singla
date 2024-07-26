#include <stdio.h>
#include <stdlib.h>

void bnsh(int * arr, int n, int target) {
	
	int start = 0;

	int end = n - 1;


	while (start <= end) {
	
		int mid = start + ( end - start ) / 2;

		if (arr[mid] == target) {
			printf("Element %d found at %d index\n", target, mid);
	      		return;	
		}

		else if (arr[mid] > target) {
			end = mid - 1;
		}

		else {
			start = mid + 1;
		}
	}

	printf("Element not Found\n");
}

int main() {

	int n;

	scanf("%d", &n);

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	int target;
	scanf("%d", &target);
	
	bnsh(arr, n, target);

	return 0;
}
