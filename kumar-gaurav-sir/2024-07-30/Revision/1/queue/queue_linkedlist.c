#include "queue.h"

typedef struct Node {
	
	int val;

	struct Node * next;
} Node;

Node * head = NULL;
Node * tail = NULL;
int N = 0;

void push(int val) {
	
	Node * node = (Node *) malloc (sizeof(Node));

	node->val = val;

	if (!head) {
		head = node;
		tail = head;
	}

	else {
		tail->next = node;
		tail = tail->next;
	}

	N++;
}

int pop() {
	
	if (empty()) {
		return INT_MIN;
	}

	int item = head->val;

	Node * temp = head;
	head = head->next;

	free(temp);
	N--;
	
	return item;
}

bool empty() {
	return N == 0;
}

int size() {
	return N;
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
