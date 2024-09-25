#include "list.h"

void test_cases()
{
	push(0);
	push(3);
	push(9);
	push(1);
	push(2);
	push(3);
	push(4);
	
	assert(size() == 7);

	assert(get(3) == 1);

	removeIdx(3);

	assert(size() == 6);

	assert(get(0) == 0);

	assert(get(3) == 2);

	removeIdx(5);

	assert(get(5) == 4);

	assert(size() == 5);

	printf("All Test Cases Passed\n");
}

int main()
{
	test_cases();
}
