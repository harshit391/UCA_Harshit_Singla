#include "queue.h"


int * arr = NULL;

int N = 0;
int front = 0;
int last = 0;

int maxsize = 1;


void resize_arr(int size) {
	
	int * temp = (int *) malloc (size * sizeof(int));
	
	int idx = 0;

	for (int i = front; i < last; i++) {
	
		temp[idx++] = arr[i];
	}

	front = 0;
	last = idx;

	int * rm = arr;
	arr = temp;

	free(rm);
}

void push(int val) {

	
	if (size() == 0) {
		resize_arr(maxsize);
	}

	else if (size() == maxsize / 2) {
		
		maxsize *= 2;

		resize_arr(maxsize);
	}
	
	arr[last++] = val;
	N++;
}

int pop() {

	if (empty()) {
		return INT_MIN;
	}

	int item = arr[front++];
	N--;

	if (size() > 0 && size() == maxsize / 4) {
		
		maxsize /= 2;

		resize_arr(maxsize);
	}
	
	return item;
}

int size() {
	
	return N;
}

bool empty() {
	return N == 0;
}

void sampletest() {

        push(3);
        push(9);
        push(1);

        assert(empty() == false);

        assert(size() == 3);

        assert(pop() == 3);

        assert(size() == 2);

        assert(pop() == 9);

        assert(size() == 1);

        assert(pop() == 1);

        assert(size() == 0);

        assert(empty());

        printf("\nAll Test Cases Passed !\n");
}

int main() {

	sampletest();

	return 0;
}
