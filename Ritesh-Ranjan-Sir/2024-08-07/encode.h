// Main Value giving Lookup 
char lookup[64] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

void encode(char  *s, int len)
{
	char out[1000];

	int n = 0, i = 0, j = 0;

	while (i < len)
	{		
		n = (s[i] << 16) & 16711680; // 0000 0000 1111 1111 0000 0000 0000 0000
		
		if (i + 1 < len)
			n |= (s[i+1] << 8) & 65280; // 0000 0000 0000 0000 1111 1111 0000 0000
		
		if (i + 2 < len)
		       	n |= (s[i+2] & 255); // 0000 0000 0000 0000 0000 0000 1111 1111


		char c = lookup[ (n >> 18)&63 ]; // It basically give 1st 6 MSB Part of the Number
 
		char c2 = lookup[ (n >> 12)&63 ]; // Next 6 Bits

		char c3 = ( i + 1 < len ) ?  lookup[ (n >> 6)&63 ] : '='; // Next 6 Bits or Handles the remaining with padding

		char c4 = ( i + 2 < len ) ? lookup[ (n&63) ] : '='; // Next 6 Bits or Handles the remaining with padding

		out[j++] = c;

		out[j++] = c2;

		out[j++] = c3;

		out[j++] = c4;

		i += 3;
	}

	out[j] = '\0';

	printf("%s\n", out);
	
}

