/* Just a Visulaizer of 2's Complement I am not Implementing The 2's Complement Here*/
#include <stdio.h>

void binary(int val)
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

	printf("\n\n");
}

int main()
{	
	int x;
	printf("Enter a Negetive Number\n");
	scanf("%d", &x);

	if (x >= 0) 
	{
		printf("That's Positive Number\n");
		return 1;
	}

	printf("Printing value of %d first\n", -x);

	binary(-x);

	printf("Now Flipping all 0s with 1s \n");

	binary(x - 1);

	printf("At Last Adding 1 at the End \n");

	binary(x);

	printf("You can see that All the Zeroes are flipped to 1 and Theres a 1 added at the very right end\n");

	return 0;
}
