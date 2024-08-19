#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <assert.h>

void swap(int* arr, int a, int b) {
	
	int temp = arr[a];

	arr[a] = arr[b];
	arr[b] = temp;
}

void selection_sort(int* arr, int n) {
	
	for (int i = 0; i < n; i++) {
		
		int min = i;

		for (int j = i + 1; j < n; j++) {
			
			if (arr[j] < arr[min]) {
				min = j;
			}
		}
		swap(arr, min, i);
	}
}

void sampletest() {
	
	int arr[] = {7, 2, 6, 4, 0, 1, 3};

	int expected[] = {0, 1, 2, 3, 4, 6, 7};

	selection_sort(arr, 7);

	for (int i = 0; i < 7; i++) {
		
		assert(arr[i] == expected[i]);
	}

	printf("All Test Cases Passed\n\n");
}

long long generate(int* arr, int n) {

	struct timeval before, after;

	gettimeofday(&before, NULL);
	
	long long before_time = before.tv_sec*1000 + before.tv_usec/1000;

	selection_sort(arr, n);

	gettimeofday(&after, NULL);

	long long after_time = after.tv_sec*1000 + after.tv_usec/1000;

	return after_time - before_time;
	
}

int main() {
	
	srand(time(NULL));

	sampletest();

	int n = 32000;
	
	int* arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	long long first = generate(arr, n);

	n = 64000;
	
	free(arr);

	arr = (int *) malloc(n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	long long second = generate(arr, n);

	printf("Time Taken in First :- %lld ms\n", first);

	printf("Time Taken in Second :- %lld ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) / first);

	free(arr);

	return 0;
}
