#include <stdio.h>

int main() {
    int num = 42;
    double pi = 3.14159;
    char str[] = "Hello, stdout!";

    fprintf(stdout, "Integer: %d\n", num);
    fprintf(stdout, "Floating-point: %f\n", pi);
    fprintf(stdout, "String: %s\n", str);

    return 0;
}
