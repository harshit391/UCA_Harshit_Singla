## <u>File Management in C</u>

#### There are two type of files in C
- **Text Files**
- **Binary Files**

<!-- Creating a table of difference between Two Types -->
| Text Files | Binary Files |
|------------|--------------|
| Human Readable | Not Human Readable |
| Can be Opened in any Text Editor | Can't be Opened in any Text Editor |
| File Extension is .txt | File Extension is .bin |
| ASCII and UTF-8 Encoding | Just 0 and 1 is There |

---

### <u>File Handling in C</u>
FILE Struct in C
```C
typedef struct _iobuf
{
    char *_ptr;
    int _cnt;
    char *_base;
    int _flag;
    int _file;
    int _charbuf;
    int _bufsiz;
    char *_tmpfname;
} FILE;
```

#### <u>File Handling Functions</u>

- **fopen()** - To Open a File
```C
FILE *fopen(const char *filename, const char *mode);
```

- **fclose()** - To Close a File
```C
int fclose(FILE *stream);
```

- **fputc()** - To Write a Character to a File
```C
int fputc(int c, FILE *stream);
```

- **fgetc()** - To Read a Character from a File
```C
int fgetc(FILE *stream);
```

- **fprintf()** - To Write a String to a File
```C
int fprintf(FILE *stream, const char *format, ...);
```

- **fscanf()** - To Read a String from a File
```C
int fscanf(FILE *stream, const char *format, ...);
```

- **fgets()** - To Read a Line from a File
```C
char *fgets(char *str, int n, FILE *stream);
```

- **fputs()** - To Write a Line to a File
```C
int fputs(const char *str, FILE *stream);
```

#### Some Practices in Class

1. [File 1](file_management.c)
2. [File 2](file_management_2.c)
3. [File 3](file_3.c)
4. [File 4](file_4.c)

---
***Homework :-***
- How it reads escape characters!
- Input - Store it binary
- Binary - Text