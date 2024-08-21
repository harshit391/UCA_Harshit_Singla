#include "stack.h"

int * arr = NULL;

int N = 0;

int maxsize = 1;

void resize_arr(int n) {

	int * newArr = (int *) malloc (n * sizeof(int));

	for (int i = 0; i < N; i++) {
		
		newArr[i] = arr[i];
	}

	int * temp = arr;

	arr = newArr;

	free(temp);

}

void push(int val) {
	
	if (N == 0) {
		
		resize_arr(maxsize);
	}

	if (N == maxsize/2) {
		
		maxsize *= 2;
		resize_arr(maxsize);
	}

	arr[N++] = val;
}

int pop() {

	if (isEmpty()) {
		return INT_MIN;	
	}

	int item = arr[--N];

	if (N == maxsize / 4) {
		maxsize /= 2;
		resize_arr(maxsize);
	}

	return item;
}

int size() {
	
	return N;
}

bool isEmpty() {
	
	return N == 0;
}

void sampletest() {
	

        push(3);
        push(10);
        push(19);

        assert(isEmpty() == false);

        assert(size() == 3);

        assert(pop() == 19);

        assert(size() == 2);

        assert(pop() == 10);

        assert(size() == 1);

        assert(pop() == 3);

        assert(size() == 0);

        assert(isEmpty());

        printf("All Test Cases Passed !\n");

}

int main() {

	sampletest();

	return 0;
}
