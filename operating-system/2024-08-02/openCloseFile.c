// Headfile for error handling
#include <errno.h>

// Headfile for file control
#include <fcntl.h>

// Standard Libraries for Input Output and using System Variables
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

// Declaring errno as external, meaning its defined elsewhere in C library
// It is used to store error code
extern int errno;

int main() {

	// Attempt to open file.txt in Read only
	// If File is not available create one
	int fd = open("file.txt", O_RDONLY | O_CREAT);
	
	// Printing file descriptor value
	printf("fd :- %d\n", fd);


	// If File descriptor failed to fetch
	if (fd == -1){
	
		printf("Error Number :- %d\n", errno);
		
		// To Print the error message code
		perror("Program");
	}
	
	// Attempt to close the file
	if (close(fd) < 0) {
		
		// If file is not able to close printing the error
		perror("c1");

		// Then Exit
		exit(1);
	}
	
	// If successfully close printing it as acknowledgement
	printf("Closed the fd.\n");

	return 0;
}
