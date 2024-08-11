#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include "queue.h"

int * arr = NULL;
int N = 0;
int max_size = 1;
int front_index = 0;
int last_index = 0;

void resize_arr(int size1) {

	int * newArr = (int *) malloc (size1 * sizeof(int));
	
	int j = 0;
	for (int i = front_index; i < last_index; i++) {
		newArr[j++] = arr[i];
	}

	int * temp = arr;
	arr = newArr;
	front_index = 0;
	last_index = 0;
	free(temp);
}

void push(int item) {
	
	if (size() == 0) {
		resize_arr(max_size);
	}

	else if (size() == max_size/2) {
		max_size *= 2;
		resize_arr(max_size);
	}


	arr[last_index++] = item;
	N++;
}

int pop() {

	if (empty()) return INT_MIN;

	int item = arr[front_index++];
	N--;

	if (size() > 0 && size() == max_size/4) {
		max_size /= 2;
		resize_arr(max_size);
	}

	return item;
}

int size() {
	return N;
}

bool empty() {
	return N == 0;
}

void testQueue() {
	
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
	
	printf("Start\n");
	testQueue();

	return 0;

}
