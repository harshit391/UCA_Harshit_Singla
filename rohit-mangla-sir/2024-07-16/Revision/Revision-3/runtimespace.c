#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>
#include <sys/resource.h>

void swap(int* arr, int a, int b) {
	
	int temp = arr[a];
	
	arr[a] = arr[b];
	arr[b] = temp;
}

void bubble_sort(int* arr, int n) {
	
	for (int i = 0; i < n - 1; i++) {
		
		for (int j = 0; j < n - i - 1; j++) {
			
			if (arr[j] > arr[j+1]) {
				swap(arr, j, j+1);
			}
		}
	}
}

void sampletest() {
	
	int arr[] = {6, 3, 1, 2, 5};

	int expected[] = {1, 2, 3, 5, 6};

	bubble_sort(arr, 5);

	for (int i = 0; i < 5; i++) {
		assert(arr[i] == expected[i]);
	}

	printf("All Test Cases Passes\n\n");
}

int main() {

	srand(time(NULL));

	sampletest();

	struct rusage s, e;
	clock_t start, end;
	
	getrusage(RUSAGE_SELF, &s);

	int n;
	scanf("%d", &n);

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	start = clock();

	bubble_sort(arr, n);

	end = clock();

	getrusage(RUSAGE_SELF, &e);

	double time_taken = ((double) (end - start) / CLOCKS_PER_SEC);
	
	long long space_taken = e.ru_maxrss - s.ru_maxrss;

	printf("Time :- %f ms\n", time_taken * 1000);
	printf("Space :- %lld KB\n", space_taken);
		
	free(arr);

	return 0;
}
