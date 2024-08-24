#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main()
{
	
	clock_t before, after;

	before = clock();

	long long int sum = 0;

	for (int i = 0; i < 1000000; i++)
	{
		sum += i;
	}

	after = clock();

	printf("Sum :- %lld\n", sum);

	double time  = ((double) (after - before)) / CLOCKS_PER_SEC;

	printf("Time Taken :- %f ms\n", time * 1000);

	return 0;	
}

