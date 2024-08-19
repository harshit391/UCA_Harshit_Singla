#include "linkedlist.h"

typedef struct Node{

	int val;
	struct Node * next;
} Node;

Node * head = NULL;
Node * tail = NULL;
int N = 0;

void insert(int idx, int val) {
	
	if (idx == 0) {
		
		Node * node = (Node *) malloc (sizeof(Node));

		node->val = val;

		head = node;

		N++;

		return;
	}

	if (idx > N) {
		return;
	}

	Node * temphead = head;
	
	for (int i = 1; i < idx; i++) {
		
		temphead = temphead->next;
	}

	Node * node = (Node *) malloc (sizeof(Node));

	node->val = val;

	if (temphead->next == NULL) {
		temphead->next = node;
	}
	else {
		node->next = temphead->next;
		temphead->next = node;
	}

	N++;
}

void push(int val) {	
	Node * node = (Node *) malloc (sizeof(Node));
	
	node->val = val;

	if (head == NULL) {	

		head = node;
		tail = head;		
	} 

	else {
		
		tail->next = node;
		tail = tail->next;
	}

	N++;
}

void pop(int idx) {
	
	if (head == NULL) {
		return;
	}

	if (idx > N) {
		return;
	}

	Node * temphead = head;

	for (int i = 1; i < idx; i++) {
		temphead = temphead->next;
	}

	if (temphead->next) {
		Node * removed = temphead->next;

		temphead->next = temphead->next->next;

		free(removed);
	}

	N--;
}

int get(int idx) {
	
	if (idx >= N) {
		return INT_MIN;
	}

	Node * temphead = head;

	for (int i = 0; i < idx; i++) {
		temphead = temphead->next;
	}

	return temphead->val;
}

int size() {
	return N;
}

bool isEmpty() {
	return N == 0;
}

void testcases() {
	
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
	
	testcases();

	return 0;
}

