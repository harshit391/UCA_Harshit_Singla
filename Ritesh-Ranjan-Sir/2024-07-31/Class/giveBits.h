#include <stdio.h>
#include <stdlib.h>

void displayBits(int x) {
	
	int * arr = (int *) malloc (32 * sizeof(int));
	
	int idx = 31;

	for (int i = 0; i < 32; i++) {	
		arr[idx--] = (x&1);
		x = x >> 1;
	}
	
	for (int i = 0; i < 32; i++) {
		printf("%d", arr[i]);
	}
	printf("\n");
}
/*
int main() {

	int n;
	scanf("%d", &n);

	displayBits(n);

	return 0;
}*/
