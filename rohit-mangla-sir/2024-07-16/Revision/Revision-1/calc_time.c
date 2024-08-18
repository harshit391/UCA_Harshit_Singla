#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main() {

	clock_t start, end;

	int n = 100000;

	int* arr = (int *) malloc (n * sizeof(int));

	start = clock();

	for (int i = 0; i < n; i++) {
		arr[i] = i + 1;
	}

	end = clock();

	double time = ((double)(end - start)) / CLOCKS_PER_SEC;

	printf("%f ms\n", time * 1000);

	return 0;
}
