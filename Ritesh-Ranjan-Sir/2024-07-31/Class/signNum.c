#include <stdio.h>

int sol1(int x) {
	
	int sign = x >> 31;
	
	int mask = (( x | ~x + 1 ) >> 31) & 1;

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
