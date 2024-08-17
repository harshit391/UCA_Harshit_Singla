#include <stdio.h>

int add(int a, int b) {
	
	return a + b;
}

int subtract(int a, int b) {

	return a - b;
}

int multiply(int a, int b) {

	return a * b;
}

int divide(int a, int b) {

	return a/b;
}

void printValue(int a, int b, int (* fun)(int, int)) {
	int val = fun(a,b);
	printf("%d ", val);
}

int main() {
	
	printValue(1, 2, add);

	printValue(3, 1, subtract);

	printValue(1, 4, multiply);

	printValue(4, 2, divide);

	printf("\n");

	return 0;
}
