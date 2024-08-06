#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

	int fd, sz;

	fd = open("newFile.txt", O_RDONLY | O_CREAT);



}
