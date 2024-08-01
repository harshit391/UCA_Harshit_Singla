#include <stdio.h>

void writefile() {
	
	// Declaring a File Pointer Variable
	FILE * fileptr;
	
	// User Friendly Prompts 
	printf("Enter the Name of File with Extension .txt:- ");
	
	char name[10000];

	scanf("\n%[^\n]%*c", name);
	
	// Finding the file using file pointer
	fileptr = fopen(name, "r");
	
	// IF File doesn't Exists
	if ( fileptr == NULL) {
	
		printf("Error File Not Found !! \n");
		return;
	}

	// If File Exists Opening the file in Write mode
	fileptr = fopen(name, "w");
	
	// User Friendly Prompt to Enter the contents of File
	printf("\nEnter the New Contents of The file :- \n");
	
	char str[100000];
	
	scanf("\n%[^\n]%*c", str);
	
	// Printing the contents entered by user into the file
	fprintf(fileptr, "%s\n", str);
	
	// Closing the file pointer to avoid memory leak
	fclose(fileptr);
	
	// An Acknowledgement of Successfull File Creation
	printf("\nFile Updation Successfull\n");	
}
