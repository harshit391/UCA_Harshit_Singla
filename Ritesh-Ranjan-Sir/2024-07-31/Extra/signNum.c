#include <stdio.h>

int sol1(int x) {
	
	/* Finding the Sign of Number */
	int sign = x >> 31;

	/* Created a Mask of Number */
	int mask = (( x | ~x + 1 ) >> 31) & 1;
	
	/* Combining the Sign with Mask  */
	return sign | mask;
}

int sol2(int x) {

	return x >> 31 | !!x;

}

int main() {

	int n = -5, n2 = 0, n3 = 5;

	printf("%d %d %d\n", sol1(n), sol1(n2), sol1(n3));
	printf("%d %d %d\n", sol2(n), sol2(n2), sol2(n3));

	return 0;
}
