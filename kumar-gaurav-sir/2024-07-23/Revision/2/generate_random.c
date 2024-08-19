#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <assert.h>

int main() {
	srand(time(NULL));

	int lower, upper, n;

	printf("Enter Lower Bound :- ");
	scanf("%d", &lower);
	printf("\n");
	
	printf("Enter Upper Bound :- ");
	scanf("%d", &upper);
	printf("\n");

	assert(lower <= upper);
	
	printf("How Many Numbers :- ");
	scanf("%d", &n);
	printf("\n");


	for (int i = 0; i < n; i++) {
		printf("%d ", rand() % (upper - lower + 1) + lower);
	}
	printf("\n");
	return 0;
}
