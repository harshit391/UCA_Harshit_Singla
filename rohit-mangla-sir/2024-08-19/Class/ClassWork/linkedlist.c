#include "list.h"

typedef struct Node
{
	int val;	
	struct Node * next;
} Node;

Node *head = NULL;
Node *tail = NULL;

int curr_size = 0;


void push(int x)
{
	if (head == NULL)
	{
		head = (Node *) malloc (sizeof(Node));
		head->val = x;
		tail = head;
		tail->next = NULL;
	}
	else
	{
		tail->next = (Node *) malloc (sizeof(Node));
		tail->next->val = x;
		tail = tail->next;
		tail->next = NULL;
	}

	curr_size++;
}

int get(int idx)
{
	if (idx >= curr_size)
	{
		return INT_MIN;
	}

	Node *temp = head;

	for (int i = 0; i < idx; i++)
	{
		temp = temp->next;
	}

	return temp->val;
}

void removeIdx(int idx)
{
	if (idx >= curr_size)
	{
		return;
	}

	Node * temp = head;

	for (int i = 1; i < idx; i++)
	{
		temp = temp->next;
	}

	if (temp->next->next == NULL)
	{
		temp->next = NULL;
	}
	else
	{
		Node *curr = temp->next;
		temp->next = temp->next->next;
		free(curr);
	}

	curr_size--;
}

int size()
{
	return curr_size;
}


