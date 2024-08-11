#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "list.h"

typedef struct Node {
	
	int val;
	struct Node * next;
} Node;

Node * head = NULL;
Node * tail = NULL;
int N = 0;

void push(int x) {
	
	Node * curr = (Node *) malloc (sizeof(Node));

	curr->val = x;

	if (head == NULL) {
		
		head = curr;
		tail = curr;
	} 
	
	else {
	
		tail->next = curr;
		tail = tail->next;
	}
	N++;
}

void pop(int x) {
	
	if (x >= N) {
		printf("Invalid Syntax\n");
		return;
	}

	Node * curr = head;
		
	if (x == 0) {
		head = head->next;
		free(curr);
		N--;
		return;
	}

	for (int i = 1; i < x; i++) {
		curr = curr->next;
	}	

	if (curr->next != NULL) {
		
		Node * temp = curr->next->next;
		Node * temp2 = curr->next;
		free(temp2);
		curr->next = temp;
	}

	N--;
}

void insert(int x, int v) {

	if (x > N) {
		printf("Invalid Index\n");
		return;
	}

	Node * curr =  head;

	if (x == 0) {
		Node * temp = (Node *) malloc (sizeof(Node));
		temp->val = v;
		temp->next =  head;
		head = temp;
		N++;
		return;
	}

	for (int i = 1; i < x; i++) {
		curr = curr->next;
	}

	Node * temp = (Node *) malloc (sizeof(Node));
	temp->val = v;
	if (curr->next == NULL) {
		curr->next = temp;
	}

	else {
		Node * curr2 = curr->next;
		curr->next = temp;
		temp->next = curr2;
	}

	N++;
}

int get(int idx) {
	if (idx >= size()) {
		return INT_MIN;
	}

	Node * curr = head;

	for (int i = 0; i < idx; i++) {
		curr = curr->next;
	}

	return curr->val;
}

int size() {
	
	return N;
}

void display() {

	Node * curr = head;

	while (curr != NULL) {
		printf("%d ", curr->val);
		curr = curr->next;
	}
	printf("\n");
}

void testList() {

	assert(size() == 0);
		
	assert(get(0) == INT_MIN);

	push(3);
	push(9);
	push(1);

	assert(size() == 3);
	
	assert(get(0) == 3);
	assert(get(1) == 9);
	assert(get(2) == 1);

	pop(1);

	assert(size() == 2);
	assert(get(0) == 3);
	assert(get(1) == 1);

	insert(1, 4);

	assert(size() == 3);

	assert(get(1) == 4);

	printf("All Test Cases Passed !\n");
}

int main() {
	
	testList();

	return 0;
}
