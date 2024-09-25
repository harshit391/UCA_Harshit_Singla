#include "calc.h"

int add(int a, int b)
{
	while (b != 0)
	{
		int carry = a & b;

		a = a ^ b;
		b = carry << 1;
	}	

	return a;
}

int sub(int a, int b)
{
	while (b != 0)
	{
		int borrow = (~a) & b;

		a = a ^ b;
		b = borrow << 1;
	}

	return a;
}

int multiply(int a, int b)
{
	int result = 0;

	while (b != 0)
	{
		if (b & 1)
		{
			result = add(result, a);
		}
		a = a << 1;
		b = b >> 1;
	}

	return result;
}

int divide(int a, int b)
{
	int quotient = 0;

	int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;

	a = (a < 0) ? -a : a;

	b = (b < 0) ? -b : b;

	for (int i = 31; i >= 0; i--)
	{
		if ((a >> i) >= b)
		{
			a = sub(a, b << i);
			quotient |= 1 << i;
		}
	}

	return sign * quotient;
}

int power(int a, int b)
{
	int result = 1;

	while (b > 0)
	{
		if (b & 1)
		{
			result = multiply(result, a);
		}
		a = multiply(a, a);
		b = b >> 1;
	}

	return result;
}

int mod(int a, int b)
{
	int quotient = divide(a, b);
	int product = multiply(quotient, b);

	return sub(a, product);
}
