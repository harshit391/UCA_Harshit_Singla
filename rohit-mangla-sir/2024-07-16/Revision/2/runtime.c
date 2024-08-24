#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	
	clock_t start, end;	

	int n = 500000;
	
	int* arr = (int*) malloc(n * sizeof(int));

	start = clock();

	for (int i = 0; i < n; i++){
		arr[i] = i + 1;
	}
	
	long long sum = 0;

	for (int i = 0; i < n; i++) {
		sum += arr[i];
	}

	end = clock();

	double taken_time = ((double)(end - start) / CLOCKS_PER_SEC);

	printf("%f ms\n", taken_time * 1000);

	printf("%lld\n", sum);

	return 0;
}
