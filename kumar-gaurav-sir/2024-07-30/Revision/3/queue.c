#include "stackqueue.h"

int *arr = NULL;

int maxSize = 1;

int front = 0, last = 0;

int N = 0;

void resizeArr(int size)
{
	int *newArr = (int *) malloc (size * sizeof(int));

	int idx = 0;
	for (int i = front; i < last; i++)
	{
		newArr[idx++] = arr[i]; 
	}

	front = 0;
	last = idx;

	int *temp = arr;

	arr = newArr;

	free(temp);
}

void push(int val)
{
	if (N == 0)
	{
		resizeArr(maxSize);
	}

	if (N == maxSize / 2)
	{
		maxSize *= 2;

		resizeArr(maxSize);
	}
	N++;
	arr[last++] = val;
}

int pop()
{
	if (N == 0)
	{
		return INT_MIN;
	}

	int item = arr[front++];

	if (N == maxSize / 4)
	{
		maxSize /= 2;

		resizeArr(maxSize);
	}
	N--;
	return item;
}	

int size()
{
	return N;
}

bool empty()
{
	return N == 0;
}

void testCases()
{
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

int main()
{
	testCases();

	free(arr);

	return 0;
}
