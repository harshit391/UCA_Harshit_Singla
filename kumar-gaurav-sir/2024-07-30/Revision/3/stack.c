#include "stackqueue.h"

int *arr = NULL;

int N = 0;

int maxSize = 1;

void resize_arr(int size)
{
	int *newArr = (int *) malloc (size * sizeof(int));

	for (int i = 0; i < N; i++)
	{
		newArr[i] = arr[i];
	}

	int *temp = arr;
	
	arr = newArr;

	free(temp);
}

void push(int val)
{
	if (N == 0)
	{
		resize_arr(maxSize);
	}

	if (N == maxSize / 2)
	{
		maxSize *= 2;
		resize_arr(maxSize);
	}
	
	arr[N++] = val;
}

int pop()
{
	if (empty())
	{
		return INT_MIN;
	}
	else
	{
		int item = arr[--N];

		if (N == maxSize / 4)
		{
			maxSize /= 2;

			resize_arr(maxSize);
		}

		return item;
	}
}

bool empty()
{
	return N == 0;
}

int size()
{
	return N;
}

void testCases()
{
	push(3);
        push(10);
        push(19);

        assert(empty() == false);

        assert(size() == 3);

        assert(pop() == 19);

        assert(size() == 2);

        assert(pop() == 10);

        assert(size() == 1);

        assert(pop() == 3);

        assert(size() == 0);

        assert(empty());

        printf("All Test Cases Passed !\n");

}

int main()
{
	testCases();

	free(arr);
	
	return 0;
}
