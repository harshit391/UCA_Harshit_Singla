#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>
#include <sys/resource.h>

void merge(int * arr, int start, int mid, int end) {

	int * result = (int * ) malloc ((end-start) * sizeof(int));

	int i = start;
	int j = mid;
	int k = 0;

	while (i < mid && j < end) {
	
		if (arr[i] < arr[j]) {
			result[k++] = arr[i++];
		} else {
			result[k++] = arr[j++];
		}
	}

	while ( i < mid ) {
		result[k++] = arr[i++];
	}

	while ( j < end ) {
		result[k++] = arr[j++];
	}

	for (int p = start; p < end; p++) {
		arr[p] = result[p - start];
	}

	free(result);
}

void divide(int * arr, int start, int end) {

	if (end - start == 1) {
		return;
	}

	int mid = start + ( end - start ) / 2;

	divide(arr, start, mid);
	divide(arr, mid, end);
	merge(arr, start, mid, end);
}

int main() {
	
	srand(time(NULL));
	
	struct rusage mstart, mend;

	clock_t start, end;

	struct timeval before, after;

	gettimeofday(&before, NULL);
	long long before_mil = before.tv_sec * 1000LL + before.tv_usec/1000;

	start = clock();

	getrusage(RUSAGE_SELF, &mstart);


	int n = 500000;

	int * arr = (int * ) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	for (int i = 0; i < 10; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");

	divide(arr, 0, n);

	for (int i = 0; i < 10; i++) {
		printf("%d ", arr[i]);
	}

	printf("\n");

	gettimeofday(&after, NULL);
	long long after_mil = after.tv_sec * 1000LL + after.tv_usec/1000;

	getrusage(RUSAGE_SELF, &mend);

	end = clock();

	double time_taken_clock = ((double)(end-start)) / CLOCKS_PER_SEC;

	long long millis = (after_mil - before_mil);

	long memo = mend.ru_maxrss - mstart.ru_maxrss;

	printf("Time Taken 1 :- %f ms\n", time_taken_clock * 1000);
	printf("Time Taken 2 :- %llu ms\n", millis);
	printf("Memory Used :- %ld KB\n", memo);

	free(arr);
	return 0;
}
