#include <stdio.h>

void print_binary(unsigned char n) {
	for (int i = 7; i >= 0; i--) {
		printf("%c", (n & ( 1 << i )) ? '1' : '0');
	}
	printf("\n");
}

int main() {
	unsigned char n = 0b11010101;
	
	unsigned char lower_mask = ~( -1 << 4 );

	unsigned char lower_nibble = (n & lower_mask ) << 4;
	
	unsigned char upper_nibble = (n & ( lower_mask << 4 )) >> 4;

	unsigned char ans = lower_nibble | upper_nibble;

	print_binary(ans);

	return 0;

}
