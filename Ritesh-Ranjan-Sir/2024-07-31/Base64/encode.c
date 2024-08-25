#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

void map(int *arr, int n, int rem, char * out)
{
	char * mp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	
	int len = 0;

	if (rem < 0)
		rem = -rem;

	if (rem > 0)
		len++;

	if (rem > 3)
		len++;

	for (int i = 0; i < n; i++)
	{
		out[i] = mp[arr[i]];
	}	

	for (int i = 0; i < len; i++)
	{
		out[n + i] = '=';
	}

	out[n + len] = '\0';

	printf("Answer Cameout :- %s\n", out);
}

void group(char * arr, char * out,  int n)
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

	map(res, size, rem, out);

	free(res);
}

void encode(char in[], char out[],  int n)
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
		
	group(arr, out, size);

	free(arr);
}

/* Thank you very much Harshpreet You made my Work Really Easy :) */
void testCases()
{

	char out[10000];

    	// Test case 1: "Harsh"
    	encode("Harsh", out, strlen("Harsh"));
    	printf("Test case 1: %s\n", out);
    	assert(strcmp(out, "SGFyc2g=") == 0);

    	// Test case 2: "Hello"
    	encode("Hello", out, strlen("Hello"));
    	printf("Test case 2: %s\n", out);
    	assert(strcmp(out, "SGVsbG8=") == 0);

    	// Test case 3: "Base64"
    	encode("Base64", out, strlen("Base64"));
    	printf("Test case 3: %s\n", out);
    	assert(strcmp(out, "QmFzZTY0") == 0);

   	 // Test case 4: "Test"
    	encode("Test", out, strlen("Test"));
    	printf("Test case 4: %s\n", out);
    	assert(strcmp(out, "VGVzdA==") == 0);

    	// Test case 5: "Test1"
    	encode("Test1", out, strlen("Test1"));
    	printf("Test case 5: %s\n", out);
    	assert(strcmp(out, "VGVzdDE=") == 0);

    	// Test case 6: Empty string
    	encode("", out, strlen(""));
    	printf("Test case 6: %s\n", out);
    	assert(strcmp(out, "") == 0);

    	// Test case 7: "Base64 encoding"
    	encode("Base64 encoding", out, strlen("Base64 encoding"));
    	printf("Test case 7: %s\n", out);
    	assert(strcmp(out, "QmFzZTY0IGVuY29kaW5n") == 0);

    	printf("All test cases passed!\n");
}

int main()
{
	testCases();

	char input[100];
	
	char output[100];

	scanf("%[^\n]%*c", input);

	int size = strlen(input);

	encode(input, output, size);

	return 0;
}
