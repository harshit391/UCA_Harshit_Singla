#include <stdio.h>
#include <assert.h>
#include <sys/time.h>
#include <time.h>
#include <stdlib.h>

void swap(int* arr, int i, int j) {
	
	int temp = arr[i];
	
	arr[i] = arr[j];
	arr[j] = temp;
}

void selection_sort(int* arr, int n) {
	
	for (int i = 0; i < n; i++) {
		
		int min = i;
		for (int j = i + 1; j < n; j++) {
			if (arr[j] < arr[min]) {
				min = j;
			}
		}
		swap(arr, i, min);
	}

}

long long calc_time(int* arr, int n) {

	struct timeval before, after;

	gettimeofday(&before, NULL);

	long long before_time = before.tv_sec*1000LL + before.tv_usec/1000;

	selection_sort(arr, n);

	gettimeofday(&after, NULL);

	long long after_time = after.tv_sec*1000LL + after.tv_usec/1000;

	return after_time - before_time;

}

void testsample() {
	
	int arr[] = {5, 2, 7, 9, 1};

	int expected[] = {1, 2, 5, 7, 9};

	selection_sort(arr, 5);

	for (int i = 0; i < 5; i++) {
		assert(arr[i] == expected[i]);
	}

	printf("Test Cases Passes\n");
}

int main() {
	
	srand(time(NULL));

	testsample();

	int n = 32000;

	int* arr = (int*) malloc(n * sizeof (int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	long long first = calc_time(arr, n);

	printf("First :- %llu ms\n", first);

	n = 64000;

	arr = (int*) malloc(n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	long long second = calc_time(arr, n);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second*1.0)/first);

	return 0;

}
