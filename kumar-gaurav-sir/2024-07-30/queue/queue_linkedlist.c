#include "queue.h"
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>

struct Node {
	
	int val;
	struct Node * next;
};

typedef struct Node Node;

Node * head = NULL;
Node * curr = NULL;

int N = 0;

void push(int x) {

	Node * newHead = (Node *) malloc (sizeof(Node));
	newHead->val = x;

	if (N == 0) {
		head = newHead;
		curr = newHead;
	} else{
		curr->next = newHead;
		curr = curr->next;
	}
	N++;
}

int pop() {
	
	if (N == 0) return INT_MIN;

	int item = head->val;

	Node * temp = head;
	head = head->next;
	N--;
	free(temp);

	return item;
}

int size() {
	return N;
}

bool empty() {
	return N == 0;
}

int testQueue() {

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

	printf("All Test Cases Passed\n");

}

int main() {
	
	testQueue();

	return 0;
}
