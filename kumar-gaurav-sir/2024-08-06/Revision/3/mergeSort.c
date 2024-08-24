#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>
#include <sys/time.h>

void merge(int * arr, int * aux, int left, int mid, int right)
{
	
	for (int i = left; i <= right; i++)
		aux[i] = arr[i];

	int i = left, j = mid + 1;

	for (int k = left; k <= right; k++)
	{
		if (i > mid)
		{
			arr[k] = aux[j++];
		}

		else if (j > right)
		{
			arr[k] = aux[i++];
		}

		else if (aux[i] <= aux[j])
		{
			arr[k] = aux[i];
			i++;
		}

		else
		{	
			arr[k] = aux[j];
			j++;
		}
	}
}

void merge_sort_rec(int * arr, int * aux, int left, int right)
{
	if (left >= right)
		return;

	int mid = left + (right - left) / 2;

	merge_sort_rec(arr, aux, left, mid);
	merge_sort_rec(arr, aux, mid + 1, right);
	merge(arr, aux, left,  mid, right);
}

void mergeSort(int * arr, int n)
{
	
	int *aux = (int *) malloc (n * sizeof(int));

	merge_sort_rec(arr, aux, 0, n - 1);
}

long long calc_time(int * arr, int n)
{
	
	struct timeval before, after;

	gettimeofday(&before, NULL);

	long long before_t = before.tv_sec * 1000LL + before.tv_usec / 1000;

	mergeSort(arr, n);
	
	gettimeofday(&after, NULL);
	
	long long after_t = after.tv_sec * 1000LL + after.tv_usec / 1000;

	return after_t - before_t;
}

void testCases()
{
	int arr[] = {9, 1, 3, 2, 5, 6, 7};

	int exp[] = {1, 2, 3, 5, 6, 7, 9};

	mergeSort(arr, 7);

	for (int i = 0; i < 7; i++)
		assert(arr[i] == exp[i]);


	printf("Test Cases Passes\n");
}

int main()
{
	srand(time(NULL));
	
	testCases();

	int n1 = 32000, n2 = 64000;

	int *arr1 = (int *) malloc (n1 * sizeof(int));

	for (int i = 0; i < n1; i++)
		arr1[i] = rand();

	long long first = calc_time(arr1, n1);

	int *arr2 = (int *) malloc (n2 * sizeof(int));

	for (int i = 0; i < n2; i++)
		arr2[i] = rand();

	long long second = calc_time(arr2, n2);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) / first);

	free(arr1);
	free(arr2);

	return 0;	
}	
