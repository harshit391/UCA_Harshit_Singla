#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void generate(int n, int lb, int ub) {
	
	for (int i = 0; i < n; i++) {
		printf("%d ", (rand() % (ub - lb + 1) + lb));
	}

	printf("\n");
}

int main() {
	srand(time(NULL));
	
	int n = 10;

	for (int i = 0; i < n; i++) {
		printf("%d ", rand());
	}

	printf("\n\n");

	generate(10, 10, 20);
		
	return 0;

}
