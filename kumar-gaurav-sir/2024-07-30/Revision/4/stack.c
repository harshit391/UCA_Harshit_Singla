#include "stack.h"


int * arr;

int currSize  = 0;

int maxSize = 1;

void resizeArray(int maxSize)
{
	int  * tempAr = (int *) malloc(maxSize * sizeof(int));

	for (int i = 0; i < currSize; i++)
	{
		tempAr[i] = arr[i];
	}

	int * curr = arr;
	
	arr = tempAr;
	free(curr);
}

void push(int x)
{
	if (currSize == 0)
	{
		resizeArray(maxSize);
	}

	else if (currSize == maxSize/2)
	{
		maxSize *= 2;
		
		resizeArray(currSize);
	}

	arr[currSize++] = x;
}

int pop()
{
	if (isEmpty())
	{
		return INT_MIN;
	}

	int curr = arr[--currSize];

	if (currSize == maxSize/4)
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

bool isEmpty()
{
	return size() == 0;
}

int peek()
{
	return arr[currSize - 1];
}

void testCases()
{
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

int main()
{
	testCases();
	
	return 0;
}
	
