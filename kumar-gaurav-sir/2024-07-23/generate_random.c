#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// srand = void srand(unsigned int seed)


// To Generate Between lower bound and upper bound

void generate(int n, int lb, int ub) {

	for (int i = 0; i < n; i++) {
		printf("%d ", (rand() % (ub - lb + 1) + lb ));
	}

	printf("\n");
}

int main() {
	
	// Set Seed based on current time
	srand(time(NULL));
	
	// Printing Random Values
	for (int i = 0; i < 10; i++) {
		printf("%d ", rand());
	}

	printf("\n");

	// Printing Lower Bound and Upper Bound
	generate(10, 20, 40);

	return 0;
}
