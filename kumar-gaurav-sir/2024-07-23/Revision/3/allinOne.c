#include <stdio.h>
#include <time.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <assert.h>
#include <stdlib.h>

void swap(int *arr, int i, int j)
{
	int temp = arr[i];
	
	arr[i] = arr[j];
	arr[j] = temp;
}

void selection_sort(int *arr, int n)
{
	
	for (int i = 0; i < n; i++)
	{
		int min = i;
		for (int j = i + 1; j < n; j++)
		{
			if (arr[min] > arr[j])
			{
				min = j;
			}
		}
		swap(arr, min, i);
	}
}

long long calcTime(int * arr, int n)
{
	struct timeval before, after;

	gettimeofday(&before, NULL);

	long long before_time = before.tv_sec*1000LL + before.tv_usec/1000;

	selection_sort(arr, n);
		
	gettimeofday(&after, NULL);

	long long after_time = after.tv_sec*1000LL + after.tv_usec/1000;

	return after_time - before_time;
}

void testCases()
{
	int arr[] = {5, 2, 8, 1, 3};

	int expect[] = {1, 2, 3, 5, 8};

	selection_sort(arr, 5);

	for (int i = 0; i < 5; i++)
	{
		assert(arr[i] == expect[i]);
	}

	printf("All Test Cases Passed\n");
}

int main()
{
	srand(time(NULL));

	testCases();

	int n1 = 32000, n2 = 64000;

	int *arr1 = (int *) malloc (n1 * sizeof(int));

	for (int i = 0; i < n1; i++)
		arr1[i] = rand();

	int *arr2 = (int *) malloc (n2 * sizeof(int));

	for (int i = 0; i < n2; i++)
		arr2[i] = rand();

	long long first = calcTime(arr1, n1);

	long long second = calcTime(arr2, n2);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) / first);

	free(arr1);
	free(arr2);

	return 0;	
		
}


