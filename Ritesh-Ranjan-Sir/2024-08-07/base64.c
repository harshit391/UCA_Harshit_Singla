#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include "encode.h"
#include "decode.h"

int main()
{
	char in[100];
	char out[100];

	scanf("%[^\n]%*c", in);

	printf("%s\n", in);

	decode(in, strlen(in));

	return 0;
}
