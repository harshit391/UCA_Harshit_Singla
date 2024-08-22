#include <stdio.h>

void print_binary(int n)
{
	for (int i = 31; i >= 0; i--)
	{
		int curr = n >> i;
		printf("%d", (curr&1));

		if (i % 4 == 0)
		{
			printf(" ");
		}
	}
	printf("\n");
}

int main()
{
	int n;
	scanf("%d", &n);
	
	print_binary(n);	
	print_binary(!n);
	print_binary(!!n);
	print_binary(n >> 31);

	return 0;
}
