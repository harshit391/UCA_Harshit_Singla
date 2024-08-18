#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>
#include <sys/resource.h>

void swap(int * arr, int a, int b){

	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
}

void selectionSort(int * arr, int n) {

	for (int i = 0; i < n; i++) {
		int min = i;

		for (int j = i + 1; j < n; j++) {
			if (arr[i] > arr[j]) {
				min = j;
			}
		}

		swap(arr, i, min);
	}
}

void testinput() {
	
	int sample[] = {6, 5, 1, 8, 9, 1, 10};

	int expected[] = {1, 1, 5, 6, 8, 9, 10};

	selectionSort(sample, 7);

	for (int i = 0; i < 7; i++) {
		assert(sample[i] == expected[i]);
	}
}

int main() {
	
	testinput();

	srand(time(NULL));

	clock_t start, end;

	struct rusage mstart, mend;

	int n;
	scanf("%d", &n);
	
	start = clock();
	
	getrusage(RUSAGE_SELF, &mstart);

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	/*
	for (int i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n"); */

	selectionSort(arr, n);

	/*
	for (int i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n"); */

	end = clock();

	getrusage(RUSAGE_SELF, &mend);	

	double time_taken = ((double)(end - start)) / CLOCKS_PER_SEC;

	long space = (mend.ru_maxrss - mstart.ru_maxrss);

	printf("Time Taken :- %f ms\n", time_taken * 1000);
	printf("Memory Consumed :- %ld KB\n", space);

	free(arr);

	return 0;	

}
