#include "sort.h"

void swap(int * arr, int i, int j)
{
	int temp = arr[i];
	
	arr[i] = arr[j];
	arr[j] = temp;
}

void quickSortRecursive(int * arr, int left, int right)
{
	if (left >= right)
		return;

	int pivot = arr[left];
	int i = left + 1;	

	for (int j = left + 1; j <= right; j++)
	{
		if (arr[j] < pivot)
		{
			swap(arr, i++, j);	
		}
	}

	swap(arr, --i, left);
	
	quickSortRecursive(arr, left, i-1);
	quickSortRecursive(arr, i+1, right);
}

void quickSort(int * arr, int n)
{
	quickSortRecursive(arr, 0, n-1);
}

void testCases()
{
	int arr[] = {3, 9, 1, 4, 2};

	int expected[] = {1, 2, 3, 4, 9};

	quickSort(arr, 5);

	for (int i = 0; i < 5; i++)
		assert(arr[i] == expected[i]);

	printf("All Test Cases Passes\n");
}

long long calcTime(int n)
{
	struct timeval before, after;

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
		arr[i] = rand();
	
	gettimeofday(&before, NULL);

	long long bf = before.tv_sec*1000LL  + before.tv_usec/1000;

	quickSort(arr, n);

	gettimeofday(&after, NULL);

	long long af = after.tv_sec*1000LL + after.tv_usec/1000;
		
	free(arr);

	return af - bf;
}

int main()
{
	srand(time(NULL));

	testCases();

	long long first = calcTime(32000);

	long long second = calcTime(64000);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) / first);
	
	return 0;
}
