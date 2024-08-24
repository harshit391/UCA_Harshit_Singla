#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>

int main()
{

	struct rusage before, after;

	getrusage(RUSAGE_SELF, &before);

	int n = 1000000;

	int *arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
	{
		arr[i] = rand();
	}

	getrusage(RUSAGE_SELF, &after);

	long long memory = (after.ru_maxrss - before.ru_maxrss);

	printf("%llu KB\n", memory);

	free(arr);

	return 0;
}



