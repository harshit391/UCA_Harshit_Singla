#include "calc.h"


void test_cases()
{
	assert(add(2, 3) == 5);
	assert(add(1, 9) == 10);


	assert(sub(10, 8) == 2);
	assert(sub(1, 2) == -1);

	assert(multiply(2, 5) == 10);
	assert(multiply(3, 1) == 3);

	assert(divide(2, 1) == 2);

	assert(power(2, 9) == 512);
	assert(power(3, 4) == 81);

	assert(mod(512, 2) == 0);
	assert(mod(87, 4) == 3);

	printf("All Test Cases Passed\n");
}


int main()
{
	test_cases();

	return 0;
}
