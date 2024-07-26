#include <stdio.h>
#include <assert.h>
#include <time.h>
#include <sys/time.h>
#include <stdlib.h>

// In Selection Sort we have to swap minimum index element and current index ele
void swap(int * arr, int i, int j) {
	
	int temp = arr[i];

	arr[i] = arr[j];
	arr[j] = temp;
}

// Normal Selection Sort Code
void selection_sort(int * arr, int n) {
	
	for (int i = 0; i < n; i++) {
		int min = i;

		for (int j = i+1; j < n; j++) {
			if ( arr[min] > arr[j] ) {
				min = j;
			}
		}

		swap(arr, i, min);
	}
}

// Calculating Run Time as we did in calc_time.c file
long long calc_time(int * arr, int n) {
	struct timeval before;
	gettimeofday(&before, NULL);

	long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

	selection_sort(arr, n);

	struct timeval after;
	gettimeofday(&after, NULL);

	long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

	return after_millis - before_millis;
}

// Integrating simple test by assert.h to test selection sort code without actual run
void test_simple_input() {
	int arr[] = {3, 1, 7, 9, 5};

	int expected[] = {1, 3, 5, 7, 9};

	selection_sort(arr, 5);

	for (int i = 0; i < 5; i++) {
		assert(arr[i] == expected[i]);
	}
}

// Main Function
int main() {

	test_simple_input();

	srand(time(NULL));

	// Selection Sort for Array of 32000 size random ele
	int k = 32000;
	int * arr1 = (int *) malloc (k * sizeof(int));

	for (int i = 0; i < k; i++) {
		arr1[i] = rand();
	}
		
	// Calculating Run time for Array 1
	long long t1 = calc_time(arr1, k);

	// Selection Sort for Array of 64000 size random ele
	k = 64000;
	int * arr2 = (int *) malloc (k * sizeof(int));
	
	for (int i = 0; i < k; i++) {
		arr2[i] = rand();
	}
	
	// Calculating Run Time for Array 2
	long long t2 = calc_time(arr2, k);
	
	// Printing Time Taken for Both Arrays
	printf("Time Elpased for Array 1 :- %llu ms\n", t1);
       	printf("Time Elapsed for Array 2 :- %llu ms\n", t2);


	// Printing Ratio of Time Taken by Array 2 to Array 1
	printf("Ratio :- %lf\n", (t2*1.0 / t1));
	return 0;
}

