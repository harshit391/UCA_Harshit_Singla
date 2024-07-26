#include <stdio.h>
#include <time.h>

int main() {
	clock_t start_time, end_time;
	double cpu_time_used;

	// Record the Start Tume 
	start_time = clock();

	// Place your code to measure execution time here
	long long int sum = 0;
	for (int i = 1; i <= 10000000; i++) {
		sum += i;
	}
	

	// Record the End Time
	end_time = clock();

	
	// Calculating CPU Time in second
	cpu_time_used = ((double) (end_time - start_time)) / CLOCKS_PER_SEC;

	printf("Sum :- %lld\n", sum);
	printf("CPU Time Used :- %f milliseconds\n", cpu_time_used * 1000);

	return 0;
}
