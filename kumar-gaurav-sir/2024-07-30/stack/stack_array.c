#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <limits.h>
#include "stack.h"

// Declaring as global variables as every function is going to access them 
// So to Clear the headache of passing them again and again
int * array = NULL;
int N = 0;
int max_size = 1;

// As per the size increase of decrease We have to resize the main Stack Array
// If the size reaches half the size of array we increase the main array size by double
// If the size decrease to 25% size of main array we decrease the main array by half
void resize_array(int size) {
	int * newArray = (int *) malloc (size * sizeof(int));

	for (int i = 0; i < N; i++) {
		newArray[i] = array[i];
	}

	int * temp = array;
	array = newArray;
	free(temp);
}

// Pushing the elements in Stack
void push(int item) { 
	
	// If Stack is Not Yet made we create it
	if (N == 0) {
		resize_array(max_size);
	}

	// If Size reachers half the size of main array we increase the main array by double
	else if (N == max_size/2) {
		resize_array(max_size * 2);
		max_size *= 2;
	}

	// Putting the element at last index which is representing the top of stack
	array[N++] = item;
}

int pop() {
	
	// If Stack is Empty It goes underflow error
	if (isEmpty()) return INT_MIN;
	
	// Retrieving the top element from the last index representing the top of stack
	int item = array[--N];

	// If the size reaches 25% size of main array we decrease the main array by half
	if (size() > 0 && size() == max_size/4) {
		max_size /= 2;
		resize_array(max_size);
	}
	
	// At last we returned the element we retrieved earlier
	return item;
}

// Return the size of curr stack
int size() {
	
	return N;
}

// Return the empty status of stack
bool isEmpty() {

	return N == 0;
}

// Check Test cases by assert library
int testStack() {
	
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

// Main
int main() {
	
	testStack();

	return 0;
}
