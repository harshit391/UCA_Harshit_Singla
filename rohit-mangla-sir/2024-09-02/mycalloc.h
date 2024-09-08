#include <stdlib.h>

int * mycalloc()
{
	int n;
	scanf("%d", &n);

	int * arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++)
		arr[i] = 0;

	return arr;
}
