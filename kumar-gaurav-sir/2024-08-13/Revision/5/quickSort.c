#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <sys/time.h>
#include <time.h>


void swap(int * arr, int i, int j)
{
	int temp = arr[i];

	arr[i] = arr[j];
	arr[j] = temp;
}

void quickSortRec(int *arr, int left, int right)
{
	if (left >= right)
		return;

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

long long giveTime(int n)
{
	int * arr = (int *) malloc (n * sizeof(int));
	
	for (int i = 0; i < n; i++)
	{
		arr[i] = rand();
	}

	struct timeval before, after;

	gettimeofday(&before, NULL);

	long long before_mil = before.tv_sec * 1000LL + before.tv_usec / 1000;

	quickSort(arr, n);

	gettimeofday(&after, NULL);

	long long after_mil = after.tv_sec * 1000LL + after.tv_usec / 1000;

	free(arr);

	return after_mil - before_mil;
}

void test()
{
	int arr[] = {8, 2, 4, 5, 9, 3, 1};

	int exp[] = {1, 2, 3, 4, 5, 8, 9};

	quickSort(arr, 7);

	for (int i = 0; i < 7; i++)
		assert(arr[i] == exp[i]);

	printf("All Test Cases Passed\n");
}

int main()
{
	test();

	srand(time(NULL));

	long long first = giveTime(256000);

	long long second = giveTime(512000);

	printf("%llu ms\n", first);

	printf("%llu ms\n", second);

	printf("%lf\n", (second * 1.0) / first);

	return 0;
}
