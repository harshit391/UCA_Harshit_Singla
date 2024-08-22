/* Basically I am converting a Hexidecimal Value to Binary Just to Visulaize How Operating System See it*/

#include <stdio.h>

void convert(int val)
{
	for (int i = 31; i >= 0; i--)
	{
		int curr = ((val >> i)&1);
		printf("%d", curr);
		if (i % 4 == 0)
		{
			printf(" ");
		}
	}
	printf("\n");
}

int main() 
{
	int hexNum;

	scanf("%x", &hexNum);
	
	/* I just ran it casually and It converts the Hex value to Decimal That's Craaaazzyyyyyy...  */
	printf("%d\n", hexNum);

	/* Converting Files to Binary */
	convert(hexNum);

	return 0;
}
