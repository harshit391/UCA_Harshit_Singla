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

long long calcTime(int *arr, int n)
{
	struct timeval before, after;
	
	gettimeofday(&before, NULL);

	long long bf = before.tv_sec*1000LL  + before.tv_usec/1000;

	quickSort(arr, n);

	gettimeofday(&after, NULL);

	long long af = after.tv_sec*1000LL + after.tv_usec/1000;

	return af - bf;
}

int main()
{
	srand(time(NULL));

	testCases();

	int n1 = 32000;

	int *arr1 = (int *) malloc (n1 * sizeof(int));

	for (int i = 0; i < n1; i++)
		arr1[i] = rand();

	long long first = calcTime(arr1, 32000);

	int n2 = 64000;

	int *arr2 = (int *) malloc (n2 * sizeof(int));

	for (int i = 0; i < n2; i++)
		arr2[i] = rand();

	long long second = calcTime(arr2, 64000);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) / first);
	
	printf("\nWorst Case\n");

	for (int i = 0; i < n1; i++)
		arr1[i] = n1 - i;

	first = calcTime(arr1, 32000);

	for (int i = 0; i < n2; i++)
		arr2[i] = n2 - i;

	second = calcTime(arr2, 64000);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) / first);
	
	free(arr1);
	free(arr2);

	return 0;
}
