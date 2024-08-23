#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void map(int *arr, int n, int rem)
{
	char * mp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	
	int len = 0;

	if (rem < 0)
		rem = -rem;

	if (rem > 0)
		len++;

	if (rem > 3)
		len++;

	int size = n + len + 1;

	char ans[100];

	for (int i = 0; i < n; i++)
	{
		ans[i] = mp[arr[i]];
	}	

	for (int i = 0; i < len; i++)
	{
		ans[n + i] = '=';
	}

	ans[n + len] = '\0';

	printf("%s\n", ans);
}

void group(char * arr, int n)
{
	int i = 0;

	int size = n / 6;

	if ((n-1) % 6 != 0)
	{
		size++;
	}

	int *res = (int *) malloc (size * sizeof(int));
	
	int idx = 0;

	while (i < n) 
	{	
		int curr = 0, pos = 0;

		for (int j = i; j < i + 6; j++)
		{
			int num = arr[j] - '0';

			if (num == 1)
			{	
				curr = (curr | (1 << (5 - pos)));
			}

			pos++;
		}

		res[idx++] = curr;

		i += 6;
	}
		
	int rem = n - (size * 6) - 1;	

	map(res, size, rem);

	free(res);
}

void encode(char in[], int n)
{
	int size = n * 8 + 1;
	char * arr = (char *) malloc (size * sizeof(char));
		
	int k = 0;

	for (int i = 0; i < n; i++) 
	{
		int num = (int)in[i];

		for (int j = 7; j >= 0; j--) 
		{
			arr[k++] = ((num >> j)&1) ? '1' : '0';	
		}
	}

	arr[k] = '\0';
		
	group(arr, size);

	free(arr);
}

int main()
{
	char input[100];

	scanf("%[^\n]%*c", input);

	int size = strlen(input);

	encode(input, size);

	return 0;
}
