#include <stdio.h>
#include <sys/time.h>
#include <time.h>
#include <stdlib.h>

int main() {
	srand(time(NULL));
		
	struct timeval before, after;

	gettimeofday(&before, NULL);

	long long before_time = before.tv_sec*1000LL + before.tv_usec/1000;

	int n = 3910000;

	long long int sum = 0;

	for (int i = 0; i < n; i++) {
		sum += i;
	}

	gettimeofday(&after, NULL);

	long long after_time = after.tv_sec*1000LL + after.tv_usec/1000;

	printf("%lld\n", sum);

	printf("Time :- %llu ms\n", after_time - before_time);

	return 0;


}
