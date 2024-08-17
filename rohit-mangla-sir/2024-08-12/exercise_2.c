#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void sort(int* arr, int size, bool (* compare)(int a, int b)) {

	for (int i = 0; i < size - 1; i++) {
		
		for (int j = 0; j < size - i - 1; j++) {
			
			if (compare(arr[j], arr[j+1])) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}

}

void printArr(int * arr, int size) {

	for (int i = 0; i < size; i++) {
		printf("%d ", arr[i]);
	}

	printf("\n");
}

bool compareAsc(int a, int b) {
	return b - a < 0;
}

bool compareDec(int a, int b) {
	return a - b < 0;
}

int main() {

	int arr[] = {1, 6, 2, 5, 4};

	printArr(arr, 5);

	sort(arr, 5, compareAsc);

	printArr(arr, 5);

	sort(arr, 5, compareDec);

	printArr(arr, 5);

	return 0;
}
