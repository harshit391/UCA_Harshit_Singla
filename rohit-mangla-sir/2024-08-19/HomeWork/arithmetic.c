#include "calc.h"

int add(int a, int b)
{
	return a + b;
}

int sub(int a, int b)
{
	return a - b;
}

int multiply(int a, int b)
{
	return a*b;
}

int divide(int a, int b)
{
	if (b == 0)
	{
		return INT_MIN;
	}
	else
	{
		return a/b;
	}
}

int power(int a, int b)
{
	int temp = a;

	for (int i = 1; i < b; i++)
	{
		temp *= a;
	}

	return temp;
}

int mod(int a, int b)
{
	if (b == 0)
	{
		return INT_MIN;
	}

	return a%b;
}
