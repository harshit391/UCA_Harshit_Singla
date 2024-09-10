#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>
#include <time.h>
#include <sys/time.h>

void mergeSort(int *arr, int *aux, int left, int mid, int right)
{
	for (int k = left; k <= right; k++)
	{
		aux[k] = arr[k];
	}

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
			arr[k] = aux[i++];
		}
		else 
		{
			arr[k] = aux[j++];
		}

	}
}

void mergeRec(int *arr, int *aux, int left, int right)
{
	if (left >= right)
		return;
	
	int mid = left + (right - left) / 2;

	mergeRec(arr, aux, left, mid);
	mergeRec(arr, aux, mid + 1, right);
	mergeSort(arr, aux, left, mid, right);
}

long long merge(int n)
{
	srand(time(NULL));

	struct timeval before, after;

	int *arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
	{
		arr[i] = rand();
	}

	gettimeofday(&before, NULL);

	long long before_mil = before.tv_sec * 1000LL + before.tv_usec / 1000;

	int *aux = (int *) malloc (n * sizeof(int));

	mergeRec(arr, aux, 0, n - 1);

	gettimeofday(&after, NULL);

	long long after_mil = after.tv_sec * 1000LL + after.tv_usec / 1000;

	free(arr);

	free(aux);

	return after_mil - before_mil;
}

void test()
{
	int arr[] = {6, 2, 3, 4, 5, 7, 1};

	int exp[] = {1, 2, 3, 4, 5, 6, 7};

	int * aux = (int *) malloc (7 * sizeof(int));

	mergeRec(arr, aux, 0, 6);

	free(aux);

	for (int i = 0; i < 7; i++)
		assert(arr[i] == exp[i]);

	printf("All Test Cases Passed\n");
}

int main()
{
	test();

	long long first = merge(256000);

	long long second = merge(512000);

	printf("%lld ms\n", first);
	printf("%lld ms\n", second);

	printf("%lf\n", ((second * 1.0) / first));

	return 0;
}
