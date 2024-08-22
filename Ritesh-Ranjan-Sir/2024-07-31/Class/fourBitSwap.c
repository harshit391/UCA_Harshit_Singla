#include <stdio.h>

int swap(int n)
{
	/* Step 1 -  Mask to Store the Swapped Values*/
	int mask = ~(-1 << 4);
	
	/* Step 2 - It will Store the Right side of 4 bits 0101 in the form 0101 0000 as left side  */
	int left_side = (n & mask) << 4; 

	/* Step 3 - It will Store the Left side of 4 bits 1101 in the form 0000 1101 as right side */
	int right_side  = (n & (mask << 4)) >> 4;
	
	/* Step 4 - At Last we combine the left_side = 0101 0000 and right_side = 0000 1101  */
	return right_side | left_side;
}

void binary(int  n)
{
	for (int i = 7; i >= 0; i--)
	{
		printf("%d", (n&(1 << i)) ? 1 : 0);	
	}
	printf("\n");
}

int main()
{
	int byte = 0b11010101;
	int ans = swap(byte);

	binary(ans);

	return 0;
}
