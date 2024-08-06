#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main() 
{

	int sz;
	
	
	int fd = open("file.txt", O_WRONLY | O_CREAT, O_TRUNC, 0644);
 
	if (fd < 0)
	{	
		perror("r1");
		exit(1);
	}
	
	sz = write(fd, "Hello World\n", strlen("Hello World\n"));
	
	fd = open("file.txt", O_RDONLY);

	char * c = (char *) malloc (100 * sizeof(char));

	sz = read(fd, c, strlen("Hello World\n"));

	c[sz] = '\0';

	close(fd);

	write(1, c, sz);

	free(c);

	return 0;

}
