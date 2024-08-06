#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main()
{	

	// To Track the file descriptor and size
	int fd, sz;
	
	// Declarting the string in which we store the content
	char * c = (char *) calloc (100, sizeof(char));
	
	// Attemp to open the file
	fd = open("file.txt", O_RDONLY);
	
	// If file not available error that file is not there
	if (fd < 0) 
	{
		perror("r1");
		exit(1);
	}
	
	// Reading up to 10 bytes from file descriptor 
	// It stores the number of bytes
	sz = read(fd, c, 10);
	
	// Acknoowledgment
	printf("Called Read ( %d, c, 10). Returned that"
			"%d byes were read/\n", fd, sz);
	
	// Teminaling the string 
	c[sz] = '\0';
	
	// Pritning the content we read from file
	printf("Those Bytes are as follow %s\n", c);

	return 0;

}
