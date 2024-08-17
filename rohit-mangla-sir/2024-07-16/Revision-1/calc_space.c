#include <stdio.h>
#include <sys/resource.h>
#include <time.h>
#include <stdlib.h>

int main() {
	srand(time(NULL));
	
	struct rusage start, end;
	
	getrusage(RUSAGE_SELF, &start);

	int n = 100000;

	int* arr = (int *)malloc(n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = i + 1;
	}

	getrusage(RUSAGE_SELF, &end);

	long space_used = end.ru_maxrss - start.ru_maxrss;

	printf("%ld KB\n", space_used);

	free(arr);

	return 0;


}
