## Short Notes for Creating Static Library

1. [Creating a Static Header File with ```.h``` extension.](#creating-a-static-header-file-with-h-extension)
2. [Creating a C Program with Implementation of Functions.](#creating-a-c-program-with-implementation-of-functions)
3. [That File Should contain that Static header file.](#that-file-should-contain-that-static-header-file)
4. [Compile the C Program with ```-c``` flag.](#compile-the-c-program-with--c-flag)
5. [Create a Static Library with ```ar rcs``` command.](#create-a-static-library-with-ar-rcs-command)
6. [Compile Any Program with the Static Library to Use the Functions.](#lets-create-another-c-file-to-use-library)
7. [Link The File Using Linker while Compiling](#compile-the-c-program-with-the-static-library)
8. [Run the Program.](#run-the-program)

### Exploring the Steps Mentioned Above

Lets Taken an Example of Addition of Two Numbers.


###### Creating a Static Header File with ```.h``` extension. 
```C
// addition.h

int add(int a, int b);
```

###### Creating a C Program with Implementation of Functions.
```C
// addition.c

int add(int a, int b) {
    return a + b;
}
```

###### That File Should contain that Static header file.
```C
// addition.c

#include "addition.h"

int add(int a, int b) {
    return a + b;
}
```

###### Compile the C Program with ```-c``` flag.
```bash
gcc -c addition.c -o addition.o
```

###### Create a Static Library with ```ar rcs``` command.
```bash
ar rcs addition_library.a addition.o
```

###### Lets Create another C file to Use Library
```C
// main.c
#include <stdio.h>
#include "addition.h"

int main() {
    int a = 10, b = 20;
    printf("Sum of %d and %d is %d\n", a, b, add(a, b));
    return 0;
}
```

###### Compile the C Program with the Static Library.
```bash
gcc main.c addition_library.a -o main
```

###### Run the Program.
```bash
./main
```
