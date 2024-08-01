#include <stdio.h>

void create() {
	
	// Declaring a File Pointer Variable
	FILE * fileptr;
	
	// User Friendly Prompts 
	printf("Enter the Name of File with Extension .txt:- ");
	
	char name[10000];

	scanf("\n%[^\n]%*c", name);
	
	// Creating and Opening the file using file pointer created above
	fileptr = fopen(name, "w");
	
	// For Some Reason if file creation failed
	if ( fileptr == NULL) {
	
		printf("Error !\n");
		return;
	}
	
	// User Friendly Prompt to Enter the contents of File
	printf("\nEnter the Contents of The file :- \n");
	
	char str[100000];
	
	scanf("\n%[^\n]%*c", str);
	
	// Printing the contents entered by user into the file
	fprintf(fileptr, "%s\n", str);
	
	// Closing the file pointer to avoid memory leak
	fclose(fileptr);
	
	// An Acknowledgement of Successfull File Creation
	printf("\nFile Creation Successfull\n");	
	printf("\nFile Name :- %s\n", name);
}
