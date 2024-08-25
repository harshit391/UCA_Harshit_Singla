#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

int giveVal(char n)
{
	if (n >= 'A' && n <= 'Z')
	{
		return n - 'A';
	}

	if (n >= 'a' && n <= 'z')
	{
		return n - 'a' + 26;
	}

	if (n >= '0' && n <= '9')
	{
		return n - '0' + 52;
	}

	if (n == '+')
	{
		return 62;
	}

	return 63;
}

void group(char arr[], int n, char * out)
{
	int i = 0;

	int idx = 0;

	while (i < n)
	{
		int num = 0;
		int pos = 0;

		for (int j = i; j < i + 8; j++)
		{
			if (arr[j] == '1')
			{
				int curr = 1 << (7 - pos);

				num = num | curr;
			}			
			pos++;
		}
		// printf("Decoded Number :- %d\n", num);

		out[idx++] = (char)(num);

		i += 8;
	}

	out[idx] = '\0';

}

void convert(int *arr, int n, char * out)
{
	char res[200];

	int idx = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 5; j >= 0; j--)
		{
			res[idx++] = ((arr[i] >> j)&1) ? '1' : '0';
		}
	}

	res[idx] = '\0';

	// printf("Length of Result String :- %d\n", idx);
	
	// printf("Printing the Result String\n");

	/* for (int i = 0; i < idx; i++)
	{
		if (i % 6 == 0)
		{
			printf(" ");
		}
		printf("%c", res[i]);
	}
	printf("\n"); */

	group(res, idx, out);
}

void decode(char arr[], char out[], int n)
{
	while (arr[n-1] == '=')
	{
		n--;
	}	

	// printf("Length of Input String :- %d\n", n);

	int *val = (int *) malloc (n * sizeof(int));
	
	for (int i = 0; i < n; i++)
	{
		val[i] = giveVal(arr[i]);
	}

	// printf("Printing the Value Array :- \n");

	/* for (int i = 0; i < n; i++)
	{
		printf("%d ", val[i]);
	}
	printf("\n"); */

	convert(val, n, out);
}

void testCases()
{
    char out[10000];

    // Test case 1: "SGFyc2g=" (Harsh)
    decode("SGFyc2g=", out, strlen("SGFyc2g="));
    printf("Test case 1: %s\n", out);
    assert(strcmp(out, "Harsh") == 0);

    // Test case 2: "SGVsbG8=" (Hello)
    decode("SGVsbG8=", out, strlen("SGVsbG8="));
    printf("Test case 2: %s\n", out);
    assert(strcmp(out, "Hello") == 0);

    // Test case 3: "QmFzZTY0" (Base64)
    decode("QmFzZTY0", out, strlen("QmFzZTY0"));
    printf("Test case 3: %s\n", out);
    assert(strcmp(out, "Base64") == 0);

    // Test case 4: "VGVzdA==" (Test)
    decode("VGVzdA==", out, strlen("VGVzdA=="));
    printf("Test case 4: %s\n", out);
    assert(strcmp(out, "Test") == 0);

    // Test case 5: "VGVzdDE=" (Test1)
    decode("VGVzdDE=", out, strlen("VGVzdDE="));
    printf("Test case 5: %s\n", out);
    assert(strcmp(out, "Test1") == 0);

    // Test case 6: "" (Empty string)
    decode("", out, strlen(""));
    printf("Test case 6: %s\n", out);
    assert(strcmp(out, "") == 0);

    // Test case 7: "QmFzZTY0IGVuY29kaW5n" (Base64 encoding)
    decode("QmFzZTY0IGVuY29kaW5n", out, strlen("QmFzZTY0IGVuY29kaW5n"));
    printf("Test case 7: %s\n", out);
    assert(strcmp(out, "Base64 encoding") == 0);

    printf("All decode test cases passed!\n");
}

int main()
{
	testCases();

	char in[100];

	scanf("%[^\n]%*c", in);

	// printf("Input Value :- %s\n", in);
	
	char out[1000];	

	decode(in, out, strlen(in));

	printf("%s\n", out);

	return 0;
}
