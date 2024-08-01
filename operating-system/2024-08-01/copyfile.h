#include <stdio.h>
#include <stdlib.h>

void copyfiles() {
	
	// Declaring a File Pointer Variable
	FILE * srcptr, * desptr;
	
	// User Friendly Prompts 
	printf("Enter the Name of Source File with Extension .txt:- ");
	
	char name[10000];

	scanf("\n%[^\n]%*c", name);
	
	// Finding the file using file pointer
	srcptr = fopen(name, "r");
	
	// IF File doesn't Exists
	if ( srcptr == NULL) {
	
		printf("Error File Not Found !! \n");
		return;
	}

	// If file Exits 
	printf("\nEnter The Name of Destination File with .txt:- ");
	scanf("\n%[^\n]%*c", name);

	// Creating a file pointer for Destination File
	desptr = fopen(name, "w");
	
	// Copying the file
	char ch;

	while ((ch = fgetc(srcptr)) != EOF) {
		fputc(ch, desptr);
	}

	// Closing Both the file pointers
	fclose(srcptr);
	fclose(desptr);
	
	// An Acknowledgement of Successfull File Copied
	printf("\nFile Copying Successfull\n");
	
	printf("\nName of the Copied File :- %s\n", name);	
}
