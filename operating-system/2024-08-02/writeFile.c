#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main() 
{
	// To store the size of content we added in file
	int sz;
	
	// Attempt to open file and if not available create one
	int fd = open("file.txt", O_WRONLY | O_CREAT, O_TRUNC, 0644);
	
	// If some error 
	if (fd < 0)
	{	
		// Printing the error
		perror("r1");
		exit(1);
	}
	
	// Storing the size of content we added in the file
	sz = write(fd, "Hello There\n", strlen("Hello There\n"));
	

	// Acknowledgment
	printf("Called Write ( %d, \"Hello There\\n\", %ld)."
		"It Returned %d\n", fd, strlen("Hello There\n"), sz);
	

	// Closing the file descriptor
	close(fd);

	return 0;

}
