#include "stack.h"

typedef struct Node{

	int val;
	struct Node * next;
} Node;

Node * head = NULL;
int N = 0;

void push(int val) {
	
	if (head == NULL) {
		
		head = (Node *) malloc (sizeof(Node));
		head->val = val;
	} else {
		
		Node * temp = (Node *) malloc (sizeof(Node));

		temp->val = val;
		temp->next = head;
		head = temp;

		
	}

	N++;
}

int pop() {
	
	int ans;

	if (head == NULL) {
		return INT_MIN;
	}
	
	else {
		ans = head->val;
		
		Node* temp = head;
		head = head->next;
		
		free(temp);		
	}
	
	N--;
	return ans;
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
