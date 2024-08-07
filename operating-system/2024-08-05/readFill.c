#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/stat.h>

#define MAX_SIZE 1000

int main() {

	int fd;

	fd = open("newFile.txt", O_RDONLY);

	if (fd < 0) {
		perror("file");
		exit(1);
		return 0;
	}

	char * content = NULL;

	ssize_t total_bytes = 0;
	ssize_t bytes_read = 0;

	char buffer[MAX_SIZE];

	while ((bytes_read =  read(fd, buffer, MAX_SIZE)) > 0) {
		
		char * curr = realloc(content, total_bytes + bytes_read + 1);

		if (curr == NULL) {
			perror("Memory allocation failed");
			free(content);
			close(fd);
			exit(1);
		}

		content = curr;

		memcpy(content + total_bytes, buffer, bytes_read);

		total_bytes += bytes_read;
	}

	if (bytes_read < 0) {
		perror("Error Reading Failed");
		free(content);
		close(fd);
		exit(1);
	}

	close(fd);

	if (content) {
		content[total_bytes] = '\0';
	}
	
	fd = open("testFile.txt", O_WRONLY | O_CREAT, 0644);

	write(fd, content, total_bytes);
	
	close(fd);

	write(1, content, total_bytes);

	free(content);

	return 0;

}
