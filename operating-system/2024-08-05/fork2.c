#include <unistd.h>
#include <stdio.h>

int main() {

	if (fork() && fork()) {
		
		printf("There\n");
	
	} else {
		printf("Here\n");

	}



}
