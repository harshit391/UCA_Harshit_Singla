#include "queue.h"

int * arr = NULL;

int front = 0;
int last = 0;

int N = 0;
int maxsize = 1;

void resize(int s) {

	int * newArr = (int *) malloc (s * sizeof(int));

	int j = 0;
	for (int i = front; i < last; i++) {
		newArr[j++] = arr[i];
	}

	front = 0;
	last = j;

	int * temp = arr;
	
	arr = newArr;
	
	free(temp);
}

void push(int v) {
	
	if (N == 0) {
		resize(maxsize);
	}

	if (N == maxsize / 2) {
		
		maxsize *= 2;

		resize(maxsize);
	}

	N++;

	arr[last++] = v;
}

int pop() {
	
	if (empty()) {
		
		return INT_MIN;
	}

	int item = arr[front++];
	N--;

	if (N == maxsize / 4) {
		
		maxsize /= 2;
		resize(maxsize);
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
