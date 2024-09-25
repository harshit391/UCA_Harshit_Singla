#include "list.h"

int * arr;
int idx = 0;
int curr_size = 0;
int max_size = 1;

void resize_array(int size)
{
	int * newTemp = (int *) malloc (size * sizeof(int));

	for (int i = 0; i < curr_size; i++)
	{
		newTemp[i] = arr[i];
	}

	int * temp = arr;
	arr = newTemp;

	free(temp);
}

void push(int x)
{
	if (curr_size == 0)
	{
		arr = (int *) malloc (max_size * sizeof(int));
	}
	arr[idx++] = x;
	curr_size++;

	if (curr_size >= max_size/2)
	{
		max_size *= 2;
		resize_array(max_size);
	}
}

int get(int idx)
{
	if (idx >= curr_size)
	{
		return INT_MIN;
	}	

	return arr[idx];
}

void removeIdx(int j)
{
	if (j >= curr_size || j < 0 || curr_size == 0)
	{
		return;
	}

	for (int i = j; i < curr_size - 1; i++)
	{
		arr[i] = arr[i + 1];
	}

	curr_size--;
	idx--;

	if (curr_size <= max_size/4)
	{
		max_size /= 2;
		resize_array(max_size);
	}
}

int size()
{
	return curr_size;
}

