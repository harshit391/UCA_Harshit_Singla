#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>

int main() {

	int fd, sz;

	fd = open("newFile.txt", O_WRONLY | O_APPEND);
	
	if (fd < 0) {
		perror("file");
		exit(1);
	}

	write(fd, "Hello There\n", strlen("Hello There\n"));

	close(fd);

	char * c = (char * ) malloc (100 * sizeof(char));

	fd = open("newFile.txt", O_RDONLY);

	sz = read(fd, c, strlen("Hello There\n"));
	
	c[sz] = '\0';

	write(1, c, sz);

	close(fd);

	free(c);	

	return 0;

}
