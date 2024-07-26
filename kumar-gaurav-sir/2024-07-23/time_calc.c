#include <stdio.h>
#include <sys/time.h>
#include <time.h>

/* timeval :- 
 
 * tv_sec - The number of whole seconds elapsed since the epoch ( for a smple calender Time - 1 january 1970;
 
 * tv_usec - The number of microseconds elapsed since the time given by tv_sec

*/

int main() {

	// Storing The Start Time of Code
	struct timeval before;
	gettimeofday(&before, NULL);
	
	// Calculating The Time Stamp at start of Code
	long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

	// Above is Converting sec to milliseconds 
	// Converting Microseconds to milliseconds
	
	long long int sum = 0;

	for (int i = 0; i < 10000000; i++) {
	
		sum += i;
	}

	// Storing the End Time of Code
	struct timeval after;
	gettimeofday(&after, NULL);

	// Calculating the Time Stamp at end of Code
	long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

	printf("Sum :- %lld\n", sum);	
	
	printf("\n");

	printf("Time Elpased :- %llu ms\n", after_millis - before_millis);

	return 0;
}	
