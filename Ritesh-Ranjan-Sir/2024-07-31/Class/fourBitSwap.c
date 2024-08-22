#include <stdio.h>

int swap(int n)
{
	
	int lower_mask = ~(-1 << 4);

	int lower_nibble = (n & lower_mask) << 4;

	int upper_nibble = (n & (lower_mask << 4)) >> 4;

	return lower_nibble | upper_nibble;
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
