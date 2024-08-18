#include <stdio.h>
#include <sys/resource.h>
#include <time.h>
#include <stdlib.h>

int main() {
	
	srand(time(NULL));
	
	struct rusage start, end;
		
	getrusage(RUSAGE_SELF, &start);

	int n = 1000000;

	int* arr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < n; i++) {
		arr[i] = rand();
	}

	getrusage(RUSAGE_SELF, &end);

	long long sp = (end.ru_maxrss - start.ru_maxrss);

	printf("%lld KB\n", sp);

	free(arr);
	
	return 0;


}
