#include <stdio.h>
#include "list.h"

typedef struct node{

	int val;
	node * next;
} node;

node * head = NULL;
node * tail = NULL;

void add(int val) {
	
	if (head == NULL) {
		head = (node * ) malloc(sizeof(node));

		head.val = val;
		tail = head;
	} else {
		
		tail.next = (node *) malloc (sizeof(node));
	}
}
