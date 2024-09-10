#include "queue.h"

int * arr;

int front = 0, last = 0, currSize = 0, maxSize = 1;


void resizeArray(int size)
{
	int * tempAr = (int *) malloc (size * sizeof(int));

	int idx = 0;

	for (int i = front; i < last; i++)
	{
		tempAr[idx++] = arr[i];
	}

	int * curr = arr;
	
	front = 0;
	last = idx;

	arr = tempAr;
	free(curr);
}

void push(int x)
{
	if (currSize == 0)
	{
		resizeArray(maxSize);
	}

	else if (currSize > maxSize / 2)
	{
		maxSize *= 2;

		resizeArray(maxSize);	
	}

	arr[last++] = x;

	currSize++;
}

int pop()
{
	if (isEmpty())
	{
		return INT_MIN;
	}

	int curr = arr[front++];

	currSize--;

	if (currSize == maxSize / 4)
	{
		maxSize /= 2;

		resizeArray(maxSize);
	}

	return curr;
}

int size()
{
	return currSize;
}

int peek()
{
	return arr[front];
}

bool isEmpty()
{
	return currSize == 0;
}

void testCases()
{
	push(3);
	push(9);
	push(1);
	
	assert(isEmpty() == false);

	assert(size() == 3);
	
	assert(pop() == 3);
	
	assert(size() == 2);
	
	assert(pop() == 9);
	
	assert(size() == 1);

	assert(pop() == 1);

	assert(size() == 0);

	assert(isEmpty());

	printf("\nAll Test Cases Passed !\n");
}

int main()
{
	testCases();

	return 0;
}
