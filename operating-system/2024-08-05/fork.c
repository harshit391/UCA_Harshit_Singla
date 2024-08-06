#include <stdio.h>
#include <unistd.h>

int main() 
{
	printf("Hello\n");

	fork();

	printf("Hello After Fork\n");

	fork();

	printf("Double Fork\n");

	return 0;


}
