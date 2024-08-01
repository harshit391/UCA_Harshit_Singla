#include <stdio.h>
#include "appendfile.h"
#include "createfile.h"
#include "writefile.h"
#include "copyfile.h"

int main() {
	
	printf("Here the Options :- \n\n");

	printf("Press 1 to Create a new File\n");
	printf("Press 2 to Write an exisiting file from scratch\n");
	printf("Press 3 to append some files in an exisiting files\n");
	printf("Press 4 to create a new file and copy the content of an existing file into new file\n");

	int n;
	scanf("%d", &n);

	
	if (n == 1) {
		create();
	}

	if (n == 2) {
		writefile();
	}

	if (n == 3) {
		appendfile();
	}

	if (n == 4) {
		copyfiles();
	}

	if (n >= 5) {
		printf("\nOnly 1 to 4 Allowed\n");
		return 1;
	}

	return 0;
}
