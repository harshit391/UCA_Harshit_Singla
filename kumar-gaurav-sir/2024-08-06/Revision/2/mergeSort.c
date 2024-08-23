#include "sort.h"

void merge(int *arr, int *aux, int left, int mid, int right)
{
	for (int i = left; i <= right; i++)
		aux[i] = arr[i];

	int i = left;
	int j = mid + 1;

	for (int k = left; k <= right; k++)
	{
		
		if (i > mid)
			arr[k] = aux[j++];

		else if (j > right)
			arr[k] = aux[i++];

		else if (aux[i] <= aux[j])
			arr[k] = aux[i++];

		else
			arr[k] = aux[j++];
	}

}

void mergeSortRecursive(int *arr, int *aux,  int left, int right)
{
	if (left >= right)
		return;

	int mid = left + ( right - left) / 2;

	mergeSortRecursive(arr, aux, left, mid);
	mergeSortRecursive(arr, aux, mid+1, right);
	merge(arr, aux, left, mid, right);
}	

void mergeSort(int * arr, int n)
{
	int *aux = (int *) malloc (n * sizeof(int));

	mergeSortRecursive(arr, aux, 0, n-1);

	free(aux);
}

void testCases()
{
	int arr[] = {3, 9, 1, 4, 2};

	int expected[] = {1, 2, 3, 4, 9};

	mergeSort(arr, 5);

	
	for (int i = 0; i < 5; i++)
		assert(arr[i] == expected[i]);

	printf("All Test Cases Passed\n");
}

long long calcTime(int n)
{
	struct timeval before, after;

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
		arr[i] = rand();
	
	gettimeofday(&before, NULL);

	long long bf = before.tv_sec*1000LL  + before.tv_usec/1000;

	mergeSort(arr, n);

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
