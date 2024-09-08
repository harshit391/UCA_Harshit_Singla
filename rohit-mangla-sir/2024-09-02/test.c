#include <stdio.h>
#include "mycalloc.h"

int main()
{
	int * arr = mycalloc();

	int s = sizeof(arr) / sizeof(int);

	for (int i = 0; i < s; i++)
	{
		printf("%d ", arr[i]);
	}

	return 0;
}
