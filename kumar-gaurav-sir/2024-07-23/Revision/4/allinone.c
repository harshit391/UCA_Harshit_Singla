#include <time.h>
#include <sys/time.h>
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

void swap(int *arr, int i, int j)
{
	int temp = arr[i];

	arr[i] = arr[j];

	arr[j] = temp;
}

void selectionSort(int *arr, int n)
{
	for (int i = 0; i < n; i++)
	{
		int min = i;

		for (int j = i + 1; j < n; j++)
		{
			if (arr[j] < arr[min])
			{
				min = j;
			}
		}

		swap(arr, min, i);
	}
}

long long calc_time(int n)
{
	struct timeval before, after;

	int *arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
		arr[i] = rand();

	gettimeofday(&before, NULL);

	long long before_millis = before.tv_sec * 1000LL + before.tv_usec / 1000;

	selectionSort(arr, n);

	gettimeofday(&after, NULL);

	long long after_millis = after.tv_sec * 1000LL + after.tv_usec / 1000;

	free(arr);

	return after_millis - before_millis;
}

void testCases()
{
	int arr[] = {5, 2, 1, 7, 8, 9, 0};

	int expected[] = {0, 1, 2, 5, 7, 8, 9};

	selectionSort(arr, 7);

	for (int i = 0; i < 7; i++)
		assert(arr[i] == expected[i]);

	printf("All Test Cases Passed\n");
}

int main()
{
	srand(time(NULL));

	testCases();

	long long first = calc_time(32000);

	long long second = calc_time(64000);

	printf("First :- %llu ms\n", first);

	printf("Second :- %llu ms\n", second);

	printf("Ratio :- %lf\n", (second * 1.0) /  first);
}
