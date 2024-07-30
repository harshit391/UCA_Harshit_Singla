#include <stdio.h>
#include <stdlib.h>
#include <sys/resource.h>
#include <time.h>

int main() {
	srand(time(NULL));

	// Recording The Start of Memory Usage
	struct rusage usage_start;
	
	getrusage(RUSAGE_SELF, &usage_start);

	// Place your code to measure memory usage here
	int * array = (int *) malloc (50000 * sizeof (int) );

	for (int i = 0; i < 50000; i++) {
		array[i] = i + 1;
	}
	
	// Recording the End of Memory Usage	
	struct rusage usage_end;

	getrusage(RUSAGE_SELF, &usage_end);

	// Calculate memory usage in kilobytes
	long memory_used = usage_end.ru_maxrss - usage_start.ru_maxrss;

	printf("Memory Used :- %ld KB\n", memory_used);

	// Free the Allocated Memory
	free(array);

	return 0;
}
