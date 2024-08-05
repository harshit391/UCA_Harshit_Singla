#include <stdio.h>

int main() {
	
	int arr[] = {1, 2, 4, 5, 6};

	int * ptr = arr;

	printf("arr + 1 :- %d\n", *(arr + 1));
	printf("arr + 4 :- %d\n", *(arr + 4));
	printf("arr + 5 :- %d\n", *(arr + 5));

	return 0;
}
