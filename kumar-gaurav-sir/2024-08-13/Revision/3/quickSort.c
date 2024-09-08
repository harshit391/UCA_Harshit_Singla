#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <assert.h>

void swap(int *arr, int i, int j)
{
	int temp = arr[i];

	arr[i] = arr[j];
	arr[j] = temp;
}

void quickSortRec(int *arr, int left, int right)
{
	if (left >= right)
	{
		return;
	}

	int pivot = arr[left];
	int j = left + 1;

	for (int i = left + 1; i <= right; i++)
	{
		if (arr[i] < pivot)
		{
			swap(arr, j++, i);
		}
	}

	swap(arr, --j, left);

	quickSortRec(arr, j + 1, right);
	quickSortRec(arr, left, j - 1);
}

void quickSort(int *arr, int n)
{
	quickSortRec(arr, 0, n - 1);
}

long long calcTime(int n)
{
	struct timeval before, after;

	int *arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
		arr[i] = rand();

	gettimeofday(&before, NULL);

	long long before_time = before.tv_sec * 1000LL + before.tv_usec / 1000;

	quickSort(arr, n);

	gettimeofday(&after, NULL);

	free(arr);

	long long after_time = after.tv_sec * 1000LL + after.tv_usec / 1000;

	return after_time - before_time;
}

void testCases()
{
	int arr[] = {3, 9, 1, 4, 2, 5, 7};

	int expected[] = {1, 2, 3, 4, 5, 7, 9};

	quickSort(arr, 7);

	for (int i = 0; i < 7; i++)
		assert(arr[i] == expected[i]);

	printf("All Test Cases Passes\n");
}	

int main()
{
	srand(time(NULL));

	testCases();

	long long first = calcTime(32000);

	long long second = calcTime(64000);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0 / first));

	return 0;
}
