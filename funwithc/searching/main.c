#include "search.h"
#include "binary.h"
#include "linear.h"

long long giveTime(int *arr, int n, int target, int (*func)(int *, int, int))
{
	
	struct timeval before, after;

	gettimeofday(&before, NULL);

	long long before_time = before.tv_sec * 1000LL + before.tv_usec / 1000;

	int ans = func(arr, n, target);

	gettimeofday(&after, NULL);

	long long after_time = after.tv_sec * 1000LL + after.tv_usec / 1000;

	return after_time - before_time;
}

int main() 
{
	srand(time(NULL));

	int n = 100000000;

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
	{
		arr[i] = rand();
	}

	int idx = (rand() % (n + 1));

	int target = arr[idx];

	printf("Index to Search :- %d\n", idx);

	long long first = giveTime(arr, n, target, binarySearch);

	long long second = giveTime(arr, n, target, linearSearch);

	printf("Binary Search :- %llu ms\n", first);
	printf("LinearSearch :- %llu ms\n", second);
	
	free(arr);

	return 0;
}
