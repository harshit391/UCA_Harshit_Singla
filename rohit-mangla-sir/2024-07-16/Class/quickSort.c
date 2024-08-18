#include <stdio.h>
#include <time.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <stdlib.h>

void sort(int * arr, int start, int end) {
	
	if (start >= end) {
		return;
	}

	int low = start, high = end;

	int mid = low + ( high - low ) / 2;
	
	int pivot = arr[mid];

	while (low <= high) {
		
		while (arr[low] < pivot) {
			low++;
		}

		while (arr[high] > pivot) {
			high--;
		}

		while (low <= high) {
			int temp = arr[low];
			
			arr[low] = arr[high];
			arr[high] = temp;

			low++;
			high--;
		}
	}

	sort(arr, start, high);
	sort(arr, low, end);
}

int main() {
	srand(time(NULL));

	clock_t start, end;

	struct timeval before, after;

	struct rusage mstart, mend;
	
	start = clock();
	gettimeofday(&before, NULL);
	long long before_mill = before.tv_sec*1000LL + before.tv_usec/1000;

	getrusage(RUSAGE_SELF, &mstart);

	int k;
	scanf("%d", &k);
	
	int * arr = (int * ) malloc (k * sizeof(int));

	for (int i = 0; i < k; i++) {
		arr[i] = rand();
	}

	sort(arr, 0, k-1);

	getrusage(RUSAGE_SELF, &mend);
	end = clock();
	gettimeofday(&after, NULL);
	long long after_mill = after.tv_sec*1000LL + after.tv_usec/1000;

	double time_taken = ((double)(end - start)) / CLOCKS_PER_SEC;

	long long time_ela = after_mill - before_mill;

	long mem_use = (mend.ru_maxrss - mstart.ru_maxrss);

	printf("Time Taken 1 :- %f ms\n", time_taken * 1000);
	printf("Time Taken 2 :- %llu ms\n", time_ela);
	printf("Memory :- %ld KB\n", mem_use);
	
	free(arr);

	return 0;
}
